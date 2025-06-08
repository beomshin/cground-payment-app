package com.kr.cground.service;

import com.kr.cground.dto.requset.PaymentRequest;
import com.kr.cground.exception.PaymentException;
import com.kr.cground.persistence.entity.PaymentsEntity;
import com.kr.cground.persistence.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public PaymentsEntity addPayment(PaymentRequest paymentRequest) throws PaymentException {
        return null;
    }

    @Override
    public PaymentsEntity getPayment(String transactionId) throws PaymentException {
        return null;
    }
}
