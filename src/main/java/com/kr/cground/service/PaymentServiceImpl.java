package com.kr.cground.service;

import com.kr.cground.constants.ResponseResult;
import com.kr.cground.dto.requset.PaymentRequest;
import com.kr.cground.exception.PaymentException;
import com.kr.cground.persistence.entity.PaymentsEntity;
import com.kr.cground.persistence.entity.enums.PaymentMethod;
import com.kr.cground.persistence.entity.enums.PaymentStatus;
import com.kr.cground.persistence.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public PaymentsEntity addPayment(PaymentRequest paymentRequest) throws PaymentException {

        var transcationId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);

        var payment = PaymentsEntity.builder()
                .orderNumbr(paymentRequest.getOrderNumber())
                .paymentStatus(PaymentStatus.SUCCESS)
                .paymentMethod(PaymentMethod.CARD)
                .transactionId(transcationId)
                .userId(paymentRequest.getUserId())
                .amount(paymentRequest.getAmount())
                .paidAt(new Timestamp(new Date().getTime()))
                .build();

        return paymentRepository.save(payment);
    }

    @Override
    public PaymentsEntity getPayment(String transactionId) throws PaymentException {
        var payment = paymentRepository.findByTransactionId(transactionId);

        if (payment.isEmpty()) {
            throw new PaymentException(ResponseResult.NOT_EXIST_PAYMENT);
        }

        return payment.get();
    }
}
