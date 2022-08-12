package com.example.authenticationWithRest.tokenGenerator;

import com.example.authenticationWithRest.model.User;

import java.util.Map;

public interface TokenGeneratorSevice {
    public abstract Map<String, String> generateToken(User user);
}
