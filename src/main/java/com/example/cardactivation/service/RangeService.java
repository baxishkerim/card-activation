package com.example.cardactivation.service;


import com.example.cardactivation.entity.RangeAssignment;
import com.example.cardactivation.entity.RangeEntity;
import com.example.cardactivation.exception.NotFoundException;
import com.example.cardactivation.mapper.RangeMerchantMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
@Slf4j

//todo зачем этот сервис если ты его не используешь??
public class RangeService {

        private RangeMerchantMapper rangeMapper;
        private RangeEntity rangeEntity;

       private RangeAssignment checkRangeAssignment(Long id) {

               return Optional.ofNullable(rangeMapper.checkRange(id))
                       .orElseThrow(() -> new NotFoundException("Range_NOT_FOUND"));
        }

        protected void getRangeById(Long id,String range){

            List<RangeEntity> rangeEntitiesList = rangeMapper.getRangeMerchant(id);

            if (rangeEntitiesList.size() == 0){
                throw new NotFoundException("No ranges for merchant with id " + id);
            }
            boolean isRangeSuccess = false;
            for (RangeEntity rangeEntity : rangeEntitiesList) {

                boolean startsWith = range.startsWith("5111");
                boolean  endWith = range.endsWith("4612");
                String from =  rangeEntity.getFrom();
                String to = rangeEntity.getTo();
                if (startsWith && endWith) {
                    if (Long.parseLong(from) < Long.parseLong(range) &&Long.parseLong(to)>
                    Long.parseLong(range)) {
                    isRangeSuccess = true;
                    };
                }
            }
            if (!isRangeSuccess) {
                throw new NotFoundException("Wrong Range");
}
        }

}
