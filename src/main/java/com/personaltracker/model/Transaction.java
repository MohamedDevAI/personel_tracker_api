package com.personaltracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    @Field("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    private Date date;

    @Field("month")
    private String month;

    @Field("category")
    private String category;

    @Field("description")
    private String description;

    @Field("paymentMethod")
    private String paymentMethod;

    @Field("amount")
    private Double amount;

    @Field("type")
    private String type; // "Credit" or "Debit"

    // Helper methods for classification
    public boolean isCredit() {
        return "Credit".equalsIgnoreCase(this.type) || "CREDIT".equalsIgnoreCase(this.type);
    }

    public boolean isDebit() {
        return "Debit".equalsIgnoreCase(this.type) || "DEBIT".equalsIgnoreCase(this.type);
    }

    // Type setter with normalization to Title Case ("Credit" / "Debit")
    public void setType(String type) {
        if (type != null) {
            if ("credit".equalsIgnoreCase(type)) {
                this.type = "Credit";
            } else if ("debit".equalsIgnoreCase(type)) {
                this.type = "Debit";
            } else {
                this.type = type;
            }
        } else {
            this.type = null;
        }
    }

    // Auto calculate month from date if missing
    public void setDate(Date date) {
        this.date = date;
        if (this.date != null && (this.month == null || this.month.isBlank())) {
            SimpleDateFormat monthFmt = new SimpleDateFormat("MMM", Locale.ENGLISH);
            monthFmt.setTimeZone(TimeZone.getTimeZone("UTC"));
            this.month = monthFmt.format(this.date);
        }
    }

    // Backwards-compatible / frontend-friendly getters & setters:

    @JsonProperty("amountSar")
    public Double getAmountSar() {
        return this.amount != null ? Math.abs(this.amount) : null;
    }

    @JsonProperty("amountSar")
    public void setAmountSar(Double amountSar) {
        if (this.amount == null) {
            this.amount = amountSar;
        }
    }

    @JsonProperty("note")
    public String getNote() {
        return this.description;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        if (this.description == null || this.description.isBlank()) {
            this.description = note;
        }
    }

    @JsonProperty("categoryId")
    public String getCategoryId() {
        return this.category;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(String categoryId) {
        if (this.category == null || this.category.isBlank()) {
            this.category = categoryId;
        }
    }

    @JsonProperty("categoryName")
    public String getCategoryName() {
        return this.category;
    }

    @JsonProperty("transactionDate")
    public String getTransactionDate() {
        if (this.date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.format(this.date);
        }
        return null;
    }

    @JsonProperty("transactionDate")
    public void setTransactionDate(String txDate) {
        if (txDate != null && !txDate.isBlank() && this.date == null) {
            try {
                if (txDate.contains("T")) {
                    SimpleDateFormat isoSdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    this.date = isoSdf.parse(txDate);
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                    this.date = sdf.parse(txDate);
                }
                if (this.month == null && this.date != null) {
                    SimpleDateFormat monthFmt = new SimpleDateFormat("MMM", Locale.ENGLISH);
                    monthFmt.setTimeZone(TimeZone.getTimeZone("UTC"));
                    this.month = monthFmt.format(this.date);
                }
            } catch (Exception ignored) {}
        }
    }
}
