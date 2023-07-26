package org.safaricom.et.student.model;

import lombok.*;
import org.safaricom.et.student.response.AddressResponse;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Address extends Common{
    private String city;
    private String subCity;
    private String woreda;
    private String kebele;
    private String houseNo;

    @OneToMany
    private List<Phone> phones;

}
