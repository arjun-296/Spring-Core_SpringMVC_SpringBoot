package com.niit.Rest_mongo_Product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(){
    super();
    }

    public ProductNotFoundException(String message){
        super(message);
    }


}
