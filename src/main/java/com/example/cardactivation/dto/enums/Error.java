package com.example.cardactivation.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {


    NETWORK_ERROR("Network error", 23102),
    ACCESS_DENIED("Access denied", 23103),
    INTERNAL_ERROR("Internal error", 23105),
    DATABASE_ERROR("Database error", 31301)
    ;

    private String errorDescription;
    private Integer errorCode;
}
