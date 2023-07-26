package org.safaricom.et.payment.service;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.model.AcademicYear;
import org.safaricom.et.payment.model.PaymentPeriod;
import org.safaricom.et.payment.repo.AcademicYearRepo;
import org.safaricom.et.payment.repo.PaymentPeriodRepo;
import org.safaricom.et.payment.request.PaymentPeriodRequest;
import org.safaricom.et.payment.response.PaymentPeriodResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentPeriodService {
    private final PaymentPeriodRepo paymentPeriodRepo;
    private final AcademicYearRepo academicYearRepo;

    public PaymentPeriodResponse create(PaymentPeriodRequest request) {
        AcademicYear year = academicYearRepo.findById(request.getAcademicYear()).orElseThrow(() -> new RuntimeException(String.format("No Academic year found with id %s", request.getAcademicYear())));
        if (paymentPeriodRepo.findByName(request.getName()) == null) {
            PaymentPeriod period = PaymentPeriod.builder()
                    .name(request.getName())
                    .description(request.getDescription())
                    .fromDate(request.getFromDate())
                    .toDate(request.getToDate())
                    .academicYear(year)
                    .build();
            return paymentPeriodRepo.save(period).paymentPeriodResponse();
        }
        return null;
    }

    public List<PaymentPeriodResponse> getAll() {
        return paymentPeriodRepo.findAll().stream().map(PaymentPeriod::paymentPeriodResponse).collect(Collectors.toList());
    }
}
