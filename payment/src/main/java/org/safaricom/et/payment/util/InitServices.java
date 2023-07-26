package org.safaricom.et.payment.util;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.payment.service.StatusService;
import org.safaricom.et.payment.service.StudentCategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitServices {
    private final StatusService statusService;
    private final StudentCategoryService studentCategoryService;

    @Bean
    public CommandLineRunner onInit() {
        return args -> {
            System.out.println("<<<<===============================Executing on Init tasks===============================>>>>");
            statusService.onInit();
            studentCategoryService.onInit();

        };
    }
}
