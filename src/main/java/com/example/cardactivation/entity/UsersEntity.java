package com.example.cardactivation.entity;


import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class UsersEntity {


    private Long id;

    private  String username;

    private String  password;

    private List<RolesEntity> roles;

    private Timestamp created;

    private Timestamp updated;

    private String executor;



}
