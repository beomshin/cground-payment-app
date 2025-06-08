package com.kr.cground.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseResult {

    SUCESS("0000", "성공"),
    FAIL_ORDER("4001", "결제실패"),
    FAIL_FIND_PAYMENT("4002", "결제조회실패"),
    NOT_EXIST_PAYMENT("4003", "미등록결제"),
    NOT_EXIST_STORE("4004", "미등록상점"),
    BAD_PARAM("3001", "파라미터 오류"),
    FAIL_REQUEST("3000", "서버 시스템 오류")

    ;

    private final String code;
    private final String message;
}
