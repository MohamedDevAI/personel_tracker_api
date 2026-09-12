package com.personaltracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Planned Repayment record stored in MongoDB Atlas.
 * Tracks scheduled debt repayment plans with creditors (INR).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "planned_repayments")
public class PlannedRepayment {

    @Id
    private String id;

    @Field("creditorName")
    private String creditorName;

    @Field("targetDate")
    private String targetDate;

    @Field("targetMonth")
    private String targetMonth; // e.g. "Dec"

    @Field("plannedAmount")
    private Double plannedAmount;

    @Field("status")
    private String status; // "Scheduled", "Paid", "Pending"

    @Field("notes")
    private String notes;

    @Field("createdAt")
    private String createdAt;
}
