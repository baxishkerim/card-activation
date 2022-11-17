package com.example.cardactivation.model;


import lombok.Data;


//todo зачем этот обьект если он не используется?
@Data
public class CardActivate {

    private String pan;
    private boolean activateSmsNotification;


}
