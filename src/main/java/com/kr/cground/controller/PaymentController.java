package com.kr.cground.controller;

import com.kr.cground.constants.ResponseResult;
import com.kr.cground.dto.requset.PaymentRequest;
import com.kr.cground.exception.PaymentException;
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


    @PostMapping("/cground/payment")
    public ResponseEntity<?> addPayment(
            @Valid @RequestBody PaymentRequest paymentRequest
    ) throws PaymentException {
        var result = ResponseResult.SUCESS;

        return ResponseEntity.ok(Map.of(
                "resultCode", result.getCode(),
                "resultMsg", result.getMessage()
        ));
    }

    @GetMapping("/cground/payment/{paymentNumber}")
    public ResponseEntity<?> getPayment(@PathVariable String paymentNumber) throws PaymentException {
        var result = ResponseResult.SUCESS;

        return ResponseEntity.ok(Map.of(
                "resultCode", result.getCode(),
                "resultMsg", result.getMessage()
        ));
    }


}
