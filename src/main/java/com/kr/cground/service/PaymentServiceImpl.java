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
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private static final Random random = new Random();


    @Override
    @Transactional
    public PaymentsEntity addPayment(PaymentRequest paymentRequest) throws PaymentException {

        boolean isError = random.nextInt(10) == 0;
        PaymentStatus status;

        if (isError) {
            // 5~10초 사이 랜덤 대기
            int sleepTime = 5000 + random.nextInt(5001); // 5000~10000ms
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}
            status = PaymentStatus.FAILED;
        } else {
            // 1~3초 사이 랜덤 대기
            int sleepTime = 1000 + random.nextInt(2001); // 1000~3000ms
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}
            status = PaymentStatus.SUCCESS;
        }

        var transcationId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);

        var payment = PaymentsEntity.builder()
                .orderNumbr(paymentRequest.getOrderNumber())
                .paymentStatus(status)
                .paymentMethod(PaymentMethod.random())
                .paymentGateway("CGROUND")
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
