package com.example.authenticationWithRest.tokenGenerator;

import com.example.authenticationWithRest.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenGeneratorSeviceImpl implements TokenGeneratorSevice{

    @Override
    public Map<String, String> generateToken(User user) {

        String jwttoken= Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();

        Map<String, String> map= new HashMap<>();
        map.put("token",jwttoken);
        map.put("msg","Logged In");
        return map;
    }
}
