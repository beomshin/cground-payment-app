package com.kr.cground.persistence.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@ToString
@AllArgsConstructor
public enum PaymentMethod {
    CARD("CARD"),
    BANK("BANK"),
    GITF("GITF"),
    ;

    private String code;

    private static final PaymentMethod[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static PaymentMethod random() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
