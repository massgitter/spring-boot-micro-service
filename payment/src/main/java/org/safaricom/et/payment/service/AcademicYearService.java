package org.safaricom.et.payment.service;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.model.AcademicYear;
import org.safaricom.et.payment.repo.AcademicYearRepo;
import org.safaricom.et.payment.request.AcademicYearRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcademicYearService {
    private final AcademicYearRepo academicYearRepo;

    public String create(AcademicYearRequest request) {
        AcademicYear year = AcademicYear.builder()
                .year(request.getYear())
                .build();
        academicYearRepo.save(year);
        return String.format("%s Registered Successfully", year.getYear());
    }
}
