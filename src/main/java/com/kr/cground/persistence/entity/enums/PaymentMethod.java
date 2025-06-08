package com.kr.cground.persistence.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum PaymentMethod {
    CARD("CARD"),
    BANK("BANK"),
    GITF("GITF"),
    ;

    private String code;
}
