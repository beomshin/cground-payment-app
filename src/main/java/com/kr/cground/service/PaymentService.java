package com.kr.cground.service;

import com.kr.cground.dto.requset.PaymentRequest;
import com.kr.cground.exception.PaymentException;
import com.kr.cground.persistence.entity.PaymentsEntity;

public interface PaymentService {

    PaymentsEntity addPayment(PaymentRequest paymentRequest) throws PaymentException;

    PaymentsEntity getPayment(String transactionId) throws PaymentException;
}
