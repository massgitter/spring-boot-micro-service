package org.safaricom.et.payment.repo;

import org.safaricom.et.payment.model.PaymentPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentPeriodRepo extends JpaRepository<PaymentPeriod, Long> {
    PaymentPeriod findByName(String name);
}
