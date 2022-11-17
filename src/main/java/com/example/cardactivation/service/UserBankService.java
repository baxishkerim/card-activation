package com.example.cardactivation.service;


import com.example.cardactivation.entity.BanksEntity;
import com.example.cardactivation.exception.NotFoundException;
import com.example.cardactivation.mapper.UserBanksMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserBankService {

    private final UserBanksMapper banksMapper;

    public UserBankService(UserBanksMapper banksMapper) {
        this.banksMapper = banksMapper;
    }

    protected BanksEntity checkBank(Long userId,Long bankId) {

        Long UserBankID = Optional.ofNullable(banksMapper.findBankIdByUserId(bankId))
                .orElseThrow(() -> new NotFoundException("No found bank for user with" + bankId)
                );

        BanksEntity banksEntity = Optional.ofNullable(banksMapper.getBankList(userId))
                .orElseThrow(() -> new NotFoundException("No found bank for user with" + userId));
        return banksEntity;
    }
}
