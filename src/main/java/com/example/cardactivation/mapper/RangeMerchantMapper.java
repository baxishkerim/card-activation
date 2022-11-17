package com.example.cardactivation.mapper;


import com.example.cardactivation.entity.RangeAssignment;
import com.example.cardactivation.entity.RangeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RangeMerchantMapper {


    @Select("select * from range_assigment where range_id = #{id}")
    RangeAssignment checkRange(Long id);



     @Select("select * from range where id = #{id} ")
     List<RangeEntity> getRangeMerchant(Long id);


}
