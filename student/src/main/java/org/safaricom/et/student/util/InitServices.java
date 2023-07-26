package org.safaricom.et.student.util;

import lombok.RequiredArgsConstructor;
import org.safaricom.et.student.service.GradeService;
import org.safaricom.et.student.service.SectionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitServices {
    private final SectionService sectionService;
    private final GradeService gradeService;

    @Bean
    public CommandLineRunner onInit() {
        return args -> {
            System.out.println("<<<<===============================Executing on Init tasks===============================>>>>");
            gradeService.onInit();
            sectionService.onInit();
        };
    }
}
