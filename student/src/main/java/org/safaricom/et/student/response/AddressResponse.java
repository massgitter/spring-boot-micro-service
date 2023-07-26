package org.safaricom.et.student.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.safaricom.et.student.model.Phone;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String city;
    private String subCity;
    private String woreda;
    private String kebele;
    private String houseNo;
    private List<String> phones;
}
