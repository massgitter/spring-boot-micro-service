package org.safaricom.et.payment.service;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.model.StudentCategory;
import org.safaricom.et.payment.repo.StudentCategoryRepo;
import org.safaricom.et.payment.response.StudentCategoryResponse;
import org.safaricom.et.payment.util.StudentCategoryEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentCategoryService {
    private final StudentCategoryRepo studentCategoryRepo;

    public void create(String name) {
        if (studentCategoryRepo.findByName(name) == null) {
            StudentCategory category = StudentCategory.builder()
                    .name(name)
                    .description(name)
                    .build();
            studentCategoryRepo.save(category);

        }
    }

    public void onInit() {
        Arrays.stream(StudentCategoryEnum.values()).forEach(studentCategoryEnum -> {
            create(studentCategoryEnum.getName());
        });
    }

    public StudentCategoryResponse findById(Long id) {
        return studentCategoryRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("No Student category found with id %s", id))).studentCategoryResponse();
    }


    public List<StudentCategoryResponse> getAll() {
        return studentCategoryRepo.findAll().stream().map(StudentCategory::studentCategoryResponse).collect(Collectors.toList());
    }
}
