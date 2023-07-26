package org.safaricom.et.student.model;

import lombok.*;
import org.safaricom.et.student.response.StudentResponse;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends Common {
    private String firstName;
    private String middleName;
    private String lastName;
    private Long category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;

    @ManyToOne
    private Section section;

    public static StudentResponse studentResponse(Student student, String category, List<String> phones) {
        return StudentResponse.builder()
                .id(student.getId())
                .category(category)
                .lastName(student.getLastName())
                .firstName(student.getFirstName())
                .middleName(student.getLastName())
                .woreda(student.getAddress().getWoreda())
                .kebele(student.getAddress().getKebele())
                .houseNo(student.getAddress().getHouseNo())
                .sectionResponse(student.getSection().sectionResponse())
                .phones(phones)
                .build();
    }

}

