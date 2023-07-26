package org.safaricom.et.student.repo;

import org.safaricom.et.student.model.Grade;
import org.safaricom.et.student.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {
    Section findByName(String name);

    Section findByNameAndGrade(String name, Grade grade);
}
