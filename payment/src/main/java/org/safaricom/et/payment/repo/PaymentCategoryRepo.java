package org.safaricom.et.payment.repo;

import org.safaricom.et.payment.model.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCategoryRepo extends JpaRepository<PaymentCategory, Long> {
}
