package org.safaricom.et.payment.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AcademicYear extends Common{
    private String year;
}
