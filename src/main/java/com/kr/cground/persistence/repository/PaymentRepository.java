package com.kr.cground.persistence.repository;

import com.kr.cground.persistence.entity.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentsEntity, Long> {

    Optional<PaymentsEntity> findByTransactionId(String transactionId);
}
