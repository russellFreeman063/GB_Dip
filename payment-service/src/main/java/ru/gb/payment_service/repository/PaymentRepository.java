package ru.gb.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.payment_service.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}