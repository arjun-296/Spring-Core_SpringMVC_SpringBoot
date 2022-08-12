package com.example.authenticationWithRest.controller;

import com.example.authenticationWithRest.exception.UserNotFoundException;
import com.example.authenticationWithRest.model.User;
import com.example.authenticationWithRest.service.UserServiceImpl;
import com.example.authenticationWithRest.tokenGenerator.TokenGeneratorSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("auth/")
public class UserControl {

    //reference creation
    UserServiceImpl usl;
    TokenGeneratorSeviceImpl tsl;


    //instantiations of the refernces and autowiring
    @Autowired
    public UserControl(UserServiceImpl usl,TokenGeneratorSeviceImpl tsl) {
        this.usl = usl;
        this.tsl=tsl;
    }


    //-> http://localhost:7979/auth/register
    @PostMapping("/register")
    public ResponseEntity<?> sendUser(@RequestBody User user){
        return new ResponseEntity<>(usl.addUser(user), HttpStatus.OK);

    }

    //-> http://localhost:7979/auth/userService/get-all-users
    @GetMapping("/userService/get-all-users")
    public ResponseEntity<?> receiveUsers(){
        return new ResponseEntity<>(usl.getAllUsers(),HttpStatus.FOUND);
    }


   //-> http://localhost:7979/auth/login
    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user) throws UserNotFoundException {

        Map<String, String> map=null;

        try {

           User result = usl.authenticate(user.getUserId(), user.getPassword());

           if(result.getUserId()== user.getUserId())
           {
               map=tsl.generateToken(result);
           }
            return new ResponseEntity<>(map,HttpStatus.FOUND);
        }

        catch(UserNotFoundException ex){

            throw new UserNotFoundException();
        }
        catch(Exception e){
            return  new ResponseEntity<>("Other exception occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
