package org.safaricom.et.payment.repo;

import org.safaricom.et.payment.model.StudentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCategoryRepo extends JpaRepository<StudentCategory, Long> {
    StudentCategory findByName(String name);
}
