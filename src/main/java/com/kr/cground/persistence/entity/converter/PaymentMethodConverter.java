package com.kr.cground.persistence.entity.converter;

import com.kr.cground.persistence.entity.enums.PaymentMethod;
import com.kr.cground.persistence.entity.enums.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, String> {


    @Override
    public String convertToDatabaseColumn(PaymentMethod paymentMethod) {
        return paymentMethod.getCode();
    }

    @Override
    public PaymentMethod convertToEntityAttribute(String s) {
        return PaymentMethod.valueOf(s);
    }

}
