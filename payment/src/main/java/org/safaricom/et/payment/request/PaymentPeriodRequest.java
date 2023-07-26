package org.safaricom.et.payment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPeriodRequest {
    private String name;
    private String description;
    private Date fromDate;
    private Date toDate;
    private Long academicYear;
}
