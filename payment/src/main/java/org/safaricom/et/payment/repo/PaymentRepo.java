package org.safaricom.et.payment.repo;

import org.safaricom.et.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
