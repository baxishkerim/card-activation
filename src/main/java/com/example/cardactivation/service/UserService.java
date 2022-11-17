package com.example.cardactivation.service;


import com.example.cardactivation.entity.UsersEntity;
import com.example.cardactivation.exception.NotFoundException;
import com.example.cardactivation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.cardactivation.utils.TokenUtils;

import java.util.Optional;

@Service
public class UserService {

    private UserMapper userMapper;
    @Value("${jwt.token.secret}")
    private String tokenSecretKey;

    protected UsersEntity getUsername(String token){

        String username = TokenUtils.getUsernameFromToken(token,tokenSecretKey);


        UsersEntity userEntity = Optional.ofNullable(userMapper.getUserByUsername(username)).
                orElseThrow(()-> new NotFoundException("User with username"+username+"not found"));
    return userEntity ;

    }

    }


