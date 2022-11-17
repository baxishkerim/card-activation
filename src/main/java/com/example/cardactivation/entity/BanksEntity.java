package com.example.cardactivation.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BanksEntity {

    private Long id;
    private String name;
    private String initiatorRId;
    private Long originatorId;
    private Long institutionId;
    private boolean isAgrigator;
    private LocalDateTime created;
    private LocalDateTime updated;






}
