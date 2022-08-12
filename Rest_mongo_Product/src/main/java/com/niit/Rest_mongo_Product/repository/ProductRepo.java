package com.niit.Rest_mongo_Product.repository;

import com.niit.Rest_mongo_Product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends MongoRepository <Product, String> {
}
