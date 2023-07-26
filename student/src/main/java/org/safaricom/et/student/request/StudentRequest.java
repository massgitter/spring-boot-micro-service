package org.safaricom.et.student.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String city;
    private String subCity;
    private String woreda;
    private String kebele;
    private String houseNo;
    private List<String> phone;
    private Long grade;
    private Long section;
    private Long category;


}
