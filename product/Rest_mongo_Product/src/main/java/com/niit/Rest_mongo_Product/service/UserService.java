package com.niit.Rest_mongo_Product.service;


import com.niit.Rest_mongo_Product.model.User;

import java.util.List;

public interface UserService {

    public abstract User saveUser(User user);
    public abstract boolean removeUser(int userId);
    public abstract User findByUserId(int UserId);
    public abstract User updateUser(User user);
    public abstract List<User> listAllUser();

}
