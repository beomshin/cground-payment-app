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


    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp paymentDate;


    public static PaymentResponse from(PaymentsEntity paymentsEntity) {
        return PaymentResponse.builder().build();
    }
}
