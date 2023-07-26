package org.safaricom.et.payment.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.request.AcademicYearRequest;
import org.safaricom.et.payment.service.AcademicYearService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "AcademicYear")
@RequestMapping("/payment/academicYear")
public class AcademicYearController {
    private final AcademicYearService academicYearService;

    @PostMapping("/create")
    public String create(@RequestBody AcademicYearRequest request) {
        return academicYearService.create(request);
    }
}
