package com.example.cardactivation.service;


import com.example.cardactivation.entity.MerchantEntity;
import com.example.cardactivation.entity.UserMerchantEntity;
import com.example.cardactivation.exception.NotFoundException;
import com.example.cardactivation.mapper.MerchantEntityMapper;
import com.example.cardactivation.mapper.UserMerchantMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserMerchantService {



    private UserMerchantMapper userMerchantMapper;
    private MerchantEntityMapper merchantEntityMapper;



    protected UserMerchantEntity findMerchantIdForUser(Long userId,Long merchantId){

        UserMerchantEntity userMerchantEntity = Optional.ofNullable(userMerchantMapper
                .findMerchantForUser(userId,merchantId))
                        .orElseThrow(()->new NotFoundException("Does not exist merchant "+merchantId));
        return userMerchantEntity;
    }


    protected MerchantEntity getMerchantEntity(Long userId){

        MerchantEntity merchantEntity = Optional.ofNullable(merchantEntityMapper.findMerchantById(userId))
                .orElseThrow(()-> new NotFoundException("Wrong merchant id for user with id " + userId));
        return merchantEntity;

    }

    }



