package org.safaricom.et.payment.repo;

import org.safaricom.et.payment.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status, Long> {
    Status findByStatus(String status);
}
