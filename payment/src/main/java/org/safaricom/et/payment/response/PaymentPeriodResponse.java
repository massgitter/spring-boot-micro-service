package org.safaricom.et.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPeriodResponse {
    private Long id;
    private String name;
    private String description;
    private Date fromDate;
    private Date toDate;
    private String academicYear;
}
