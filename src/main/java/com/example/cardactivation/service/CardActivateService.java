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
    @Value("${jwt.token.secret}")
    private String tokenSecretKey;
    private UserService userService;
    private UserBankService bankService;
    private BanksEntity banksEntity;
    private UserMerchantService merchantService;
    private UserMerchantEntity userMerchantEntity;
    private MerchantEntity merchantEntityForBank;
    private RangeService rangeService;


    public ResponseEntity<ResponseObject<CardActivateResponseDTO>> activatedCard (CardActivateRequestDTO cardActivateRequestDTO, String token) {


        UsersEntity usersEntity = userService.getUsername(token);

        Long userId = usersEntity.getId();
        Long banksEntityId = banksEntity.getId();
        BanksEntity banksEntity = bankService.checkBank(userId, banksEntityId);

        Long merchantId = userMerchantEntity.getMerchantId();
        Long userMerchantId = userMerchantEntity.getUserId();
        UserMerchantEntity userMerchantEntity = merchantService.findMerchantIdForUser(merchantId, userMerchantId);

        Long bankId = merchantEntityForBank.getBankId();
        MerchantEntity merchantEntity = merchantService.getMerchantEntity(bankId);


        Long rangeGroupId = merchantEntity.getRangeGroupId();

//      List<RangeEntity> rangeEntity = rangeService.getRangeById(rangeGroupId,);

        return ResponseEntity.ok()
                .body(ResponseObject.success()
                        .title("Successful”")
                        .data(cardActivateRequestDTO));
    }
}
