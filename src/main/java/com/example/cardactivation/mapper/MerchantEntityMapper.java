package com.example.cardactivation.mapper;


import com.example.cardactivation.entity.MerchantEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MerchantEntityMapper {

    @Select("select * from merchant where id = #{id}")
    MerchantEntity findMerchantById(Long id);





}