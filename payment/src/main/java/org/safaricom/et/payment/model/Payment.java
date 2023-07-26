package org.safaricom.et.payment.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Payment extends Common{
    @ManyToOne
    private Status status;
    @ManyToOne
    private PaymentPeriod paymentPeriod;
    @ManyToOne
    private StudentPaymentCategory studentPaymentCategory;
}
