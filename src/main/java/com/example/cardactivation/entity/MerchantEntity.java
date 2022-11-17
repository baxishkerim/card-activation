package com.example.cardactivation.entity;


import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Data
public class MerchantEntity {

    private Long id;
    private String mkSideName;
    private String bankSideName;
    private String value;
    @Getter
    private Long bankId;
    private Long rangeGroupId;
    private boolean isActive;
    private LocalDateTime created;
    private LocalDateTime updated;





}
