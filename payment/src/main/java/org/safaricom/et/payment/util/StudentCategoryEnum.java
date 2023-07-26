package org.safaricom.et.payment.util;

import lombok.Getter;

@Getter
public enum StudentCategoryEnum {
    NORMAL("NORMAL"),
    FIVE_PERCENT("5% DISCOUNT"),
    TEN_PERCENT("10% DISCOUNT"),
    FIFTEEN_PERCENT("15% DISCOUNT"),
    TWENTY_FIVE_PERCENT("25% DISCOUNT"),
    FIFTY_PERCENT("50% DISCOUNT"),
    SEVENTY_FIVE_PERCENT("75% DISCOUNT"),
    STAFF_MEMBER_STUDENTS("STAFF"),
    FREE("FREE"),
    SCHOLARSHIP("SCHOLARSHIP");

    private final String name;

    StudentCategoryEnum(final String name) {
        this.name = name;
    }
}
