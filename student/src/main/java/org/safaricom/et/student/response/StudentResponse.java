package org.safaricom.et.student.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.safaricom.et.student.model.Student;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String woreda;
    private String kebele;
    private String houseNo;
    private String category;
    private List<String> phones;
    private SectionResponse sectionResponse;

    public StudentResponse(Student student, List<String> phones) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.middleName = student.getMiddleName();
        this.lastName = student.getLastName();
        this.woreda = student.getAddress().getWoreda();
        this.kebele = student.getAddress().getKebele();
        this.houseNo = student.getAddress().getHouseNo();
        this.phones = phones;
        this.sectionResponse = student.getSection().sectionResponse();
    }
}
