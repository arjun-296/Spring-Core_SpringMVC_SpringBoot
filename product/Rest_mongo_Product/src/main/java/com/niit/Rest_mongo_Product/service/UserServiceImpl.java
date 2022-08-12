package com.niit.Rest_mongo_Product.service;

import com.niit.Rest_mongo_Product.model.User;
import com.niit.Rest_mongo_Product.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean removeUser(int userId) {
         if(userRepo.findById(userId).isPresent()){
            userRepo.deleteById(userId);
            return true;
         }
         else
         {
             return false;
         }
    }

    @Override
    public User findByUserId(int UserId) {
        return userRepo.findById(UserId).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }


    @Override
    public List<User> listAllUser() {
        return userRepo.findAll();
    }
}
