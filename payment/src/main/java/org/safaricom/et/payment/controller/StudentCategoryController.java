package org.safaricom.et.payment.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.response.StudentCategoryResponse;
import org.safaricom.et.payment.service.StudentCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "StudentCategory")
@RequestMapping("/payment/student/category")
public class StudentCategoryController {
    private final StudentCategoryService studentCategoryService;

    @GetMapping("{id}")
    public StudentCategoryResponse findById(@PathVariable Long id) {
        return studentCategoryService.findById(id);
    }

    @GetMapping("/all")
    public List<StudentCategoryResponse> getAll() {
        return studentCategoryService.getAll();
    }

}
