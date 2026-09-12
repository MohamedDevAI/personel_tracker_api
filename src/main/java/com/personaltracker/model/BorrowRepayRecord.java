package com.personaltracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Borrow & Repay record stored in MongoDB Atlas.
 * Tracks money borrowed from or repaid to a creditor (INR).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "borrow_repay")
public class BorrowRepayRecord {

    @Id
    private String id;

    @Field("creditorName")
    private String creditorName;

    @Field("date")
    private String date;

    @Field("type")
    private String type; // "Borrow" or "Repaid"

    @Field("amount")
    private Double amount;

    @Field("currency")
    private String currency; // "INR"

    @Field("notes")
    private String notes;

    @Field("createdAt")
    private String createdAt;
}
