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
public class StudentPaymentCategory extends Common{
    private String description;
    private Double amount;

    @ManyToOne
    private StudentCategory studentCategory;

    @ManyToOne
    private PaymentCategory paymentCategory;
}
