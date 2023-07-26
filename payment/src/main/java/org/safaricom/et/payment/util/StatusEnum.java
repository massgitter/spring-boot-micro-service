package org.safaricom.et.payment.util;

import lombok.Getter;

@Getter
public enum StatusEnum {
    ACTIVE("ACTIVE"),
    IN_ACTIVE("IN_ACTIVE"),
    PAID("PAID"),
    PENDING("PENDING"),
    REGISTERED("REGISTERED"),
    CERTIFIED("CERTIFIED"),
    PROMOTED("PROMOTED");

    private final String name;

    StatusEnum(final String name) {
        this.name = name;
    }

}
