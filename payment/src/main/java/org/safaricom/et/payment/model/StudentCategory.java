package org.safaricom.et.payment.model;

import lombok.*;
import org.safaricom.et.payment.response.StudentCategoryResponse;

import javax.persistence.Entity;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StudentCategory extends Common{
    private String name;
    private String description;

    public StudentCategoryResponse studentCategoryResponse() {
        return StudentCategoryResponse.builder()
                .id(getId())
                .name(name)
                .description(description)
                .build();
    }
}
