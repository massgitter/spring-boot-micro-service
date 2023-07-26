package org.safaricom.et.student.controller;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.student.request.StudentRequest;
import org.safaricom.et.student.response.StudentCategoryResponse;
import org.safaricom.et.student.response.StudentResponse;
import org.safaricom.et.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/register")
    public StudentResponse register(@RequestBody StudentRequest request) {
        return studentService.register(request);
    }

    @GetMapping("/all")
    public List<StudentResponse> getAll() {
        return studentService.getAll();
    }

}
