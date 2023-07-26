package org.safaricom.et.student.model;

import lombok.*;
import org.safaricom.et.student.response.SectionResponse;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Section extends Common{
    private String name;

    @ManyToOne
    private Grade grade;

    public SectionResponse sectionResponse() {
        return SectionResponse.builder()
                .id(getId())
                .section(name)
                .grade(grade.getName())
                .build();
    }
}
