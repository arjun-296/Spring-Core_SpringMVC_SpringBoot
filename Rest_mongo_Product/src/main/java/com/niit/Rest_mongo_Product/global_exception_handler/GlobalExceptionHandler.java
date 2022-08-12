package com.niit.Rest_mongo_Product.global_exception_handler;

import com.niit.Rest_mongo_Product.error_model.ErrorResponse;
import com.niit.Rest_mongo_Product.exception.ProductAlreadyExistsException;
import com.niit.Rest_mongo_Product.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException productNotFoundException){
        HttpStatus status = HttpStatus.NOT_FOUND;

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        productNotFoundException.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();
        return new ResponseEntity<>(new ErrorResponse(status, productNotFoundException.getMessage(),stackTrace),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<?> handleProductAlreadyExists(ProductAlreadyExistsException productAlreadyExistsException)
    {
        return new ResponseEntity<>("This Product is already in the database, please " +
                "recheck the product code before entering!!!",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception){
        return new ResponseEntity<>("Unknown Error Occured",HttpStatus.BAD_REQUEST);
    }

}
