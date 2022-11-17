package com.example.cardactivation.dto;

import lombok.Data;

@Data
public class CardActivateRequestDTO {

    private String pan;
    private boolean activateSmsNotification;

}
