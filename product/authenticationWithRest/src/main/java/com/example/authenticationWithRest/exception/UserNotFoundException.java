package com.example.authenticationWithRest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="User Not Found in the Database!!!" +
        " Please re-eneter the Id and Passowrd.")
public class UserNotFoundException extends Exception{
}
