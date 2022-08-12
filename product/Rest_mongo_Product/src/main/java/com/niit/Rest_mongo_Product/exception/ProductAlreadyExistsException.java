package com.niit.Rest_mongo_Product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason="This Entry Exists in the Database.")
public class ProductAlreadyExistsException extends Exception {
}
