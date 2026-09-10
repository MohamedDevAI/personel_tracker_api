package com.personaltracker.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {
    CREDIT("Credit"),
    DEBIT("Debit");

    @JsonValue
    private final String display;

    @JsonCreator
    public static TransactionType fromString(String value) {
        if (value == null)
            return null;
        for (TransactionType t : values()) {
            if (t.name().equalsIgnoreCase(value) || t.display.equalsIgnoreCase(value)) {
                return t;
            }
        }
        return null;
    }
}
