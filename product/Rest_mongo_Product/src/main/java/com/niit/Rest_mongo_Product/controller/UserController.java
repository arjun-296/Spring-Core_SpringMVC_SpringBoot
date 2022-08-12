package com.niit.Rest_mongo_Product.controller;

import com.niit.Rest_mongo_Product.model.User;
import com.niit.Rest_mongo_Product.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userApp/v9")
public class UserController {

    UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    //->http://localhost:5656/userApp/v9/user
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    //->http://localhost:5656/productApp/v9/user
    @GetMapping("/user")
    public ResponseEntity<?> showAllUsers(){
        return new ResponseEntity<>(userService.listAllUser(), HttpStatus.FOUND);

    }

    //->http://localhost:5656/productApp/v9/user/{UserId}
    @DeleteMapping("/user/{UserId}")
    public ResponseEntity<?> removeById(@PathVariable int UserId){
        userService.removeUser(UserId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

    }

    //->http://localhost:5656/productApp/v9/user/{UserId}
    @GetMapping("/user/{UserId}")
    public ResponseEntity<?> getById(@PathVariable int UserId){
        return new ResponseEntity<>(userService.findByUserId(UserId),HttpStatus.FOUND);

    }

    //->http://localhost:5656/productApp/v9/user/update
    @PostMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
      return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
    }
}
