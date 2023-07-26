package org.safaricom.et.student.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.safaricom.et.student.client.RestClient;
import org.safaricom.et.student.model.Address;
import org.safaricom.et.student.model.Phone;
import org.safaricom.et.student.model.Student;
import org.safaricom.et.student.repo.*;
import org.safaricom.et.student.request.StudentRequest;
import org.safaricom.et.student.response.StudentCategoryResponse;
import org.safaricom.et.student.response.StudentResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final PhoneRepo phoneRepo;
    private final GradeRepo gradeRepo;
    private final SectionRepo sectionRepo;
    private final AddressRepo addressRepo;
    private final StudentRepo studentRepo;
    private final RestClient restClient;

    @Transactional
    public StudentResponse register(StudentRequest request) {
        Address address = Address.builder()
                .city(request.getCity())
                .subCity(request.getSubCity())
                .woreda(request.getWoreda())
                .kebele(request.getKebele())
                .houseNo(request.getHouseNo())
                .build();
        addressRepo.save(address);

        request.getPhone().forEach(s -> {
            Phone phone = Phone.builder()
                    .phoneNo(s)
                    .address(address)
                    .build();
            phoneRepo.save(phone);
        });

        Student student = Student.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .category(sCategory(request.getCategory()).getId())
                .address(address)
                .section(sectionRepo.findById(request.getSection()).orElse(null))
                .studentId(request.getStudentId() != null ? request.getStudentId() : RandomStringUtils.randomAlphanumeric(8))
                .build();
        studentRepo.save(student);

        String sCategory = sCategory(request.getCategory()).getName();
        return Student.studentResponse(student, sCategory, phones(student));
    }


    public List<StudentResponse> getAll() {
        return studentRepo.findAll().stream()
                .map(student -> {
                    String sCategory = sCategory(student.getCategory()).getName();
                    return Student.studentResponse(student, sCategory, phones(student));
                }).sorted(Comparator.comparing(StudentResponse::getId))
                .collect(Collectors.toList());
    }
    
    public Map<String, String> studentIdXFirstName() {
        Map<String, String> map = new HashMap<>();
        studentRepo.findAll().forEach(student -> map.put(student.getStudentId(), student.getFirstName()));
        return map;
    }

    public List<String> getAllPhones() {
        return studentRepo.findAll().stream()
                .map(Student::getAddress)
                .collect(Collectors.toList())
                .stream()
                .flatMap(address -> phoneRepo.findByAddressId(address.getId()).stream())
                .collect(Collectors.toList())
                .stream()
                .map(Phone::getPhoneNo)
                .collect(Collectors.toList());
    }

    private StudentCategoryResponse sCategory(Long id) {
        return restClient.paymentClient()
                .get()
                .uri(String.format("/student/category/%S", id))
                .retrieve()
                .bodyToFlux(StudentCategoryResponse.class)
                .blockFirst();
    }

    private List<String> phones(Student student) {
        return phoneRepo.findByAddressId(student.getAddress().getId()).stream().map(Phone::getPhoneNo).collect(Collectors.toList());
    }
}

