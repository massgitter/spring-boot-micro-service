package org.safaricom.et.student.service;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.student.model.Grade;
import org.safaricom.et.student.repo.GradeRepo;
import org.safaricom.et.student.util.GradeEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepo gradeRepo;

    public void create(String name) {
        if (gradeRepo.findByName(name) == null) {
            Grade grade = Grade.builder()
                    .name(name)
                    .build();
            gradeRepo.save(grade);
        }
    }

    public void onInit() {
        Arrays.stream(GradeEnum.values()).forEach(gradeEnum -> {
            create(gradeEnum.getName());
        });
    }
}
