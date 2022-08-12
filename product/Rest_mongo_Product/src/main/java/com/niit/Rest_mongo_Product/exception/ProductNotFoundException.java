package com.niit.Rest_mongo_Product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Entry Not Found!!!" +
        " Renter the product Code!")
public class ProductNotFoundException extends Exception {
}
