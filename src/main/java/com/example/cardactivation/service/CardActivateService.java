package com.example.cardactivation.service;


import com.example.cardactivation.dto.CardActivateRequestDTO;
import com.example.cardactivation.dto.CardActivateResponseDTO;
import com.example.cardactivation.dto.core.ResponseObject;
import com.example.cardactivation.entity.BanksEntity;
import com.example.cardactivation.entity.MerchantEntity;
import com.example.cardactivation.entity.UserMerchantEntity;
import com.example.cardactivation.entity.UsersEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CardActivateService {

    //todo dependency injection?
    @Value("${jwt.token.secret}")
    private String tokenSecretKey;
    //todo dependency injection?
    private UserService userService;
    //todo dependency injection?
    private UserBankService bankService;
    //remove from global variable.
    private BanksEntity banksEntity;
    //todo dependency injection?
    private UserMerchantService merchantService;
    //todo remove from global variable.
    private UserMerchantEntity userMerchantEntity;
    //todo remove from global variable
    private MerchantEntity merchantEntityForBank;
    //todo dependency injection?
    private RangeService rangeService;


    public ResponseEntity<ResponseObject<CardActivateResponseDTO>> activatedCard(CardActivateRequestDTO cardActivateRequestDTO, String token) {

        UsersEntity usersEntity = userService.getUsername(token);

        Long userId = usersEntity.getId();

        //todo banks entity is null. test it.
        Long banksEntityId = banksEntity.getId();

        //todo refactor.
        BanksEntity banksEntity = bankService.checkBank(userId, banksEntityId);

        //todo merchant id is null.
        Long merchantId = userMerchantEntity.getMerchantId();

        //todo merchant id is null
        Long userMerchantId = userMerchantEntity.getUserId();
        //todo обьект не используется
        UserMerchantEntity userMerchantEntity = merchantService.findMerchantIdForUser(merchantId, userMerchantId);

        //todo bank id is null.
        Long bankId = merchantEntityForBank.getBankId();

        //todo refactor
        MerchantEntity merchantEntity = merchantService.getMerchantEntity(bankId);

        //todo не используется.
        Long rangeGroupId = merchantEntity.getRangeGroupId();

//      List<RangeEntity> rangeEntity = rangeService.getRangeById(rangeGroupId,);
        //todo возвращаешь запрос????????????
        return ResponseEntity.ok()
                .body(ResponseObject.success()
                        .title("Successful”")
                        .data(cardActivateRequestDTO));
    }
}
