package com.example.authenticationWithRest.service;

import com.example.authenticationWithRest.exception.UserNotFoundException;
import com.example.authenticationWithRest.model.User;
import com.example.authenticationWithRest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    UserRepository us;

    @Autowired
    public UserServiceImpl(UserRepository us) {
        this.us = us;
    }

    @Override
    public User addUser(User user) {
        return us.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return us.findAll();
    }

    @Override
    public User authenticate(int userid, String password) throws UserNotFoundException {
        User user=us.findByUserIdAndPassword(userid, password);

        if(user!=null)
        {
            return user;
        }
        else{
            throw new UserNotFoundException();
        }
    }
}
