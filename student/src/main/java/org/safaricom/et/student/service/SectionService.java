package org.safaricom.et.student.service;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.student.model.Grade;
import org.safaricom.et.student.model.Section;
import org.safaricom.et.student.repo.GradeRepo;
import org.safaricom.et.student.repo.SectionRepo;
import org.safaricom.et.student.util.GradeEnum;
import org.safaricom.et.student.util.SectionEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final GradeRepo gradeRepo;
    private final SectionRepo sectionRepo;

    public void create(String name) {
       gradeRepo.findAll().forEach(grade -> {
           if (sectionRepo.findByNameAndGrade(name, grade) == null) {
               Section section = Section.builder()
                       .name(name)
                       .grade(grade)
                       .build();
               sectionRepo.save(section);
           }
       });
    }

    public void onInit() {
       Arrays.stream(SectionEnum.values()).forEach(sectionEnum -> create(sectionEnum.name()));
    }
}
