package com.niit.Rest_mongo_Product.repository;

import com.niit.Rest_mongo_Product.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {
}
