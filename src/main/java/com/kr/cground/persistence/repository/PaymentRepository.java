package com.kr.cground.persistence.repository;

import com.kr.cground.persistence.entity.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentsEntity, Long> {
}
