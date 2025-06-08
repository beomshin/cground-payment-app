package com.kr.cground.controller;

import com.kr.cground.constants.ResponseResult;
import com.kr.cground.dto.requset.PaymentRequest;
import com.kr.cground.dto.response.PaymentResponse;
import com.kr.cground.exception.PaymentException;
import com.kr.cground.persistence.entity.PaymentsEntity;
import com.kr.cground.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/cground/payment")
    public ResponseEntity<?> addPayment(
            @Valid @RequestBody PaymentRequest paymentRequest
    ) throws PaymentException {
        var result = ResponseResult.SUCESS;

        PaymentsEntity paymentsEntity = paymentService.addPayment(paymentRequest);

        return ResponseEntity.ok(Map.of(
                "transactionId", paymentsEntity.getTransactionId(),
                "resultCode", result.getCode(),
                "resultMsg", result.getMessage()
        ));
    }

    @GetMapping("/cground/payment/{transactionId}")
    public ResponseEntity<?> getPayment(@PathVariable String transactionId) throws PaymentException {
        var result = ResponseResult.SUCESS;

        PaymentsEntity paymentsEntity = paymentService.getPayment(transactionId);

        return ResponseEntity.ok(Map.of(
                "resultCode", result.getCode(),
                "resultMsg", result.getMessage(),
                "payment", PaymentResponse.from(paymentsEntity)
        ));
    }


}
