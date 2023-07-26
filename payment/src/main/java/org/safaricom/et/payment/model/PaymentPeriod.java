package org.safaricom.et.payment.model;

import lombok.*;
import org.safaricom.et.payment.response.PaymentPeriodResponse;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentPeriod extends Common{
    private String name;
    private String description;
    private Date fromDate;
    private Date toDate;

    @ManyToOne
    private AcademicYear academicYear;

    public PaymentPeriodResponse paymentPeriodResponse() {
        return PaymentPeriodResponse.builder()
                .id(getId())
                .name(name)
                .description(description)
                .fromDate(fromDate)
                .toDate(toDate)
                .academicYear(academicYear.getYear())
                .build();
    }
}
