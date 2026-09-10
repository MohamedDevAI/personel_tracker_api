package com.personaltracker.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "finance_planned")
public class FinancePlanned {

    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("category")
    private String category;

    @Field("month")
    private String month; // e.g. "Jul", "Aug", "Sep", etc.

    @Field("year")
    private Integer year; // 2026 or 2027

    @Field("plannedAmount")
    private Double plannedAmount;

    @Field("paidAmount")
    private Double paidAmount;

    @Field("isFulfilled")
    private Boolean isFulfilled;

    @Field("dueDate")
    private String dueDate;

    @Field("status")
    private String status; // "Fulfilled", "Partial", "Planned"

    @Field("notes")
    private String notes;

    @Field("currency")
    private String currency; // "SAR"

    @Field("createdAt")
    private String createdAt;
}
