package org.safaricom.et.payment.service;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.model.Status;
import org.safaricom.et.payment.repo.StatusRepo;
import org.safaricom.et.payment.util.StatusEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepo statusRepo;

    public void create(String name) {
        if (statusRepo.findByStatus(name) == null) {
            Status status = Status.builder()
                    .status(name)
                    .build();
            statusRepo.save(status);
        }
    }

    public void onInit() {
        Arrays.stream(StatusEnum.values()).forEach(statusEnum -> {
            create(statusEnum.getName());
        });
    }
}
