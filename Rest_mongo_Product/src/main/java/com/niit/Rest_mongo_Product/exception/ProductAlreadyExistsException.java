package com.niit.Rest_mongo_Product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ProductAlreadyExistsException extends RuntimeException{

    public ProductAlreadyExistsException(){
        super();
    }

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
