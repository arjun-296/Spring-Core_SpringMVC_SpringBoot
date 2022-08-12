package com.example.authenticationWithRest.service;

import com.example.authenticationWithRest.exception.UserNotFoundException;
import com.example.authenticationWithRest.model.User;

import java.util.List;

public interface UserService {

    public abstract User addUser(User user);
    public abstract List<User> getAllUsers();
    public abstract User authenticate(int userid, String password) throws UserNotFoundException;
}
