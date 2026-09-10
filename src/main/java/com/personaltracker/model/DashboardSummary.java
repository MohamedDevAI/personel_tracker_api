package com.personaltracker.Model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class DashboardSummary {
    private Double totalCredit;
    private Double totalDebit;
    private Double balance;
    private Map<String, Double> expensesByCategory;
}
