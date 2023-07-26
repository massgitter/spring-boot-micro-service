package org.safaricom.et.student.repo;

import org.safaricom.et.student.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {
    Grade findByName(String name);
}
