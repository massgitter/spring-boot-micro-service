package org.safaricom.et.payment.repo;

import org.safaricom.et.payment.model.StudentPaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPaymentCategoryRepo extends JpaRepository<StudentPaymentCategory, Long> {
}
