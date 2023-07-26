package org.safaricom.et.payment.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.request.PaymentPeriodRequest;
import org.safaricom.et.payment.response.PaymentPeriodResponse;
import org.safaricom.et.payment.service.PaymentPeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "PaymentPeriod")
@RequestMapping("/payment/paymentPeriod")
public class PaymentPeriodController {
    private final PaymentPeriodService paymentPeriodService;

    @PostMapping("/create")
    public PaymentPeriodResponse create(@RequestBody PaymentPeriodRequest request) {
        return paymentPeriodService.create(request);
    }

    @GetMapping("/all")
    public List<PaymentPeriodResponse> getAll() {
        return paymentPeriodService.getAll();
    }
}
