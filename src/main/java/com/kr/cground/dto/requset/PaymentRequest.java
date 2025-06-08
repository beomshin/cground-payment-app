package com.kr.cground.dto.requset;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentRequest {

    @NotBlank(message = "주문번호가 누락되었습니다.")
    private String orderNumber;

    @NotNull(message = "금액이 누락되었습니다.")
    private Integer amount;

    @NotBlank(message = "유저번호가 누락되었습니다.")
    private String userId;

}
