package com.personaltracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    CREDIT("Credit"),
    DEBIT("Debit");

    private final String display;

    TransactionType(String display) {
        this.display = display;
    }

    @JsonValue
    public String getDisplay() {
        return display;
    }

    @JsonCreator
    public static TransactionType fromString(String value) {
        if (value == null) return null;
        for (TransactionType t : values()) {
            if (t.name().equalsIgnoreCase(value) || t.display.equalsIgnoreCase(value)) {
                return t;
            }
        }
        return null;
    }
}
