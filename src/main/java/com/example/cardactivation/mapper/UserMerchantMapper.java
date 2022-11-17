package com.example.cardactivation.mapper;


import com.example.cardactivation.entity.UserMerchantEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMerchantMapper {


    //todo что то странное. Зачем искать два поля по двум полям?
    //todo ForUser?
    @Select("select * from user_merchants where user_id = #{userId} and merchant_id = #{merchantId}")
    UserMerchantEntity findMerchantForUser(Long userId, Long merchantId);
}
