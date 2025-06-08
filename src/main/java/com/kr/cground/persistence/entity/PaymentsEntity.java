package com.kr.cground.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kr.cground.persistence.entity.common.BaseEntity;
import com.kr.cground.persistence.entity.converter.PaymentMethodConverter;
import com.kr.cground.persistence.entity.converter.PaymentStatusConverter;
import com.kr.cground.persistence.entity.enums.PaymentMethod;
import com.kr.cground.persistence.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;
import java.util.List;

@Getter
@SuperBuilder
@ToString(callSuper=true)
@Entity(name = "payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
public class PaymentsEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "order_number")
    private String orderNumbr;

    @Column(name = "payment_status")
    @Convert(converter = PaymentStatusConverter.class)
    private PaymentStatus paymentStatus;

    @Column(name = "payment_method")
    @Convert(converter = PaymentMethodConverter.class)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_gateway")
    private String paymentGateway;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "paid_at")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp paidAt;

    @Column(name = "fail_reason")
    private String failReason;

}
