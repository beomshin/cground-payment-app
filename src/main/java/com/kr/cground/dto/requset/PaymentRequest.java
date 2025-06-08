package com.kr.cground.dto.requset;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentRequest {

    private String orderNumber;

    private Integer amount;

    private String userId;

}
