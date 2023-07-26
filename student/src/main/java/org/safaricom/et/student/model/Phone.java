package org.safaricom.et.student.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Phone extends Common{
    private String phoneNo;

    @ManyToOne
    private Address address;

}
