package com.kr.cground.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kr.cground.persistence.entity.PaymentsEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentResponse {

    private String orderNumber;

    private String paymentStatus;

    private String paymentMethod;

    private String paymentGateway;

    private String transactionId;

    private String userId;

    private Integer amount;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp paymentDate;

    private String fail_reason;


    public static PaymentResponse from(PaymentsEntity paymentsEntity) {
        return PaymentResponse.builder()
                .orderNumber(paymentsEntity.getOrderNumbr())
                .paymentStatus(paymentsEntity.getPaymentStatus().getCode())
                .paymentMethod(paymentsEntity.getPaymentMethod().getCode())
                .paymentGateway(paymentsEntity.getPaymentGateway())
                .transactionId(paymentsEntity.getTransactionId())
                .userId(paymentsEntity.getUserId())
                .amount(paymentsEntity.getAmount())
                .paymentDate(paymentsEntity.getPaidAt())
                .fail_reason(paymentsEntity.getFailReason())
                .build();
    }
}
