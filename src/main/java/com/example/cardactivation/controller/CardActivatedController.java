package com.example.cardactivation.controller;


import com.example.cardactivation.dto.CardActivateRequestDTO;
import com.example.cardactivation.dto.CardActivateResponseDTO;
import com.example.cardactivation.dto.core.ResponseObject;
import com.example.cardactivation.service.CardActivateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CardActivatedController {


    private final CardActivateService cardActivateService;


    @RequestMapping("/cardholder/cardActivated")
    public ResponseEntity<ResponseObject<CardActivateResponseDTO>> activatedCard
            (@RequestBody CardActivateRequestDTO activateRequestDTO, @RequestHeader("Authorization") String token) {
        return cardActivateService.activatedCard(activateRequestDTO, token);
    }


}
