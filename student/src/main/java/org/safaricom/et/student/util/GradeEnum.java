package org.safaricom.et.student.util;

import lombok.Getter;

@Getter
public enum GradeEnum {
    NURSERY("NURSERY"),
    KG_1("KG-1"),
    KG_2("KG-2"),
    KG_3("KG-3"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    ELEVEN("11"),
    TWELVE("12");

    private final String name;

    GradeEnum(final String name) {
        this.name = name;
    }
}
