package com.personaltracker.config;

import com.personaltracker.Model.FinancePlanned;
import com.personaltracker.Repository.FinancePlannedRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FinancePlannedDataLoader implements CommandLineRunner {

    private final FinancePlannedRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            log.info("Populating initial data for MongoDB collection 'finance_planned'...");
            List<FinancePlanned> plans = new ArrayList<>();

            // July 2026 (Sum: 2384.86, Complete)
            plans.add(createPlan("Laptop", "Shopping", "Jul", 2026, 748.17, 748.17, true, "Fulfilled",
                    "Laptop allocation"));
            plans.add(createPlan("Recharge", "Utilities", "Jul", 2026, 103.5, 103.5, true, "Fulfilled",
                    "Mobile / data recharge"));
            plans.add(createPlan("Bakala", "Grocery", "Jul", 2026, 500.0, 500.0, true, "Fulfilled",
                    "Bakala grocery supplies"));
            plans.add(createPlan("Tabby", "Credit Payback", "Jul", 2026, 85.5, 85.5, true, "Fulfilled",
                    "Tabby installment"));
            plans.add(createPlan("Tamara", "Credit Payback", "Jul", 2026, 46.1, 46.1, true, "Fulfilled",
                    "Tamara installment"));
            plans.add(createPlan("Tablet", "Shopping", "Jul", 2026, 750.0, 750.0, true, "Fulfilled", "Tablet device"));
            plans.add(createPlan("Tabby", "Credit Payback", "Jul", 2026, 54.87, 54.87, true, "Fulfilled",
                    "Tabby installment"));
            plans.add(createPlan("Tabby", "Credit Payback", "Jul", 2026, 48.36, 48.36, true, "Fulfilled",
                    "Tabby installment"));
            plans.add(createPlan("Tabby", "Credit Payback", "Jul", 2026, 48.36, 48.36, true, "Fulfilled",
                    "Tabby installment"));

            // August 2026 (Sum: 4889.05)
            plans.add(
                    createPlan("Laptop", "Shopping", "Aug", 2026, 748.17, 0.0, false, "Planned", "Laptop installment"));
            plans.add(
                    createPlan("Recharge", "Utilities", "Aug", 2026, 103.5, 0.0, false, "Planned", "Monthly recharge"));
            plans.add(
                    createPlan("Bakala", "Grocery", "Aug", 2026, 350.0, 0.0, false, "Planned", "Provisions & grocery"));
            plans.add(createPlan("Tamara", "Credit Payback", "Aug", 2026, 25.64, 0.0, false, "Planned",
                    "Tamara installment"));
            plans.add(
                    createPlan("Tabby", "Credit Payback", "Aug", 2026, 364.0, 0.0, false, "Planned", "Tabby payment"));
            plans.add(createPlan("Food", "Food", "Aug", 2026, 97.74, 0.0, false, "Planned", "Food expenses"));
            plans.add(createPlan("Expense Home", "Family Expense", "Aug", 2026, 3000.0, 0.0, false, "Planned",
                    "Home budget"));
            plans.add(createPlan("Tabby", "Credit Payback", "Aug", 2026, 200.0, 0.0, false, "Planned",
                    "Tabby installment"));

            // September 2026 (Sum: 4741.02)
            plans.add(
                    createPlan("Laptop", "Shopping", "Sep", 2026, 748.17, 0.0, false, "Planned", "Laptop installment"));
            plans.add(
                    createPlan("Recharge", "Utilities", "Sep", 2026, 103.5, 0.0, false, "Planned", "Monthly recharge"));
            plans.add(createPlan("Bakala", "Grocery", "Sep", 2026, 350.0, 0.0, false, "Planned", "Provisions"));
            plans.add(createPlan("Tamara", "Credit Payback", "Sep", 2026, 25.64, 0.0, false, "Planned",
                    "Tamara installment"));
            plans.add(createPlan("Tabby", "Credit Payback", "Sep", 2026, 200.0, 0.0, false, "Planned",
                    "Tabby installment"));
            plans.add(createPlan("Tamara", "Credit Payback", "Sep", 2026, 84.08, 0.0, false, "Planned",
                    "Tamara payment"));
            plans.add(createPlan("Tabby", "Credit Payback", "Sep", 2026, 29.63, 0.0, false, "Planned",
                    "Tabby installment"));
            plans.add(createPlan("Expense Home", "Family Expense", "Sep", 2026, 3200.0, 0.0, false, "Planned",
                    "Home transfer"));

            // October 2026 (Sum: 4826.31)
            plans.add(
                    createPlan("Laptop", "Shopping", "Oct", 2026, 748.17, 0.0, false, "Planned", "Laptop installment"));
            plans.add(
                    createPlan("Recharge", "Utilities", "Oct", 2026, 103.5, 0.0, false, "Planned", "Monthly recharge"));
            plans.add(createPlan("Bakala", "Grocery", "Oct", 2026, 350.0, 0.0, false, "Planned", "Provisions"));
            plans.add(createPlan("Tamara", "Credit Payback", "Oct", 2026, 25.64, 0.0, false, "Planned",
                    "Tamara installment"));
            plans.add(createPlan("Tabby", "Credit Payback", "Oct", 2026, 198.0, 0.0, false, "Planned",
                    "Tabby installment"));
            plans.add(createPlan("Google Subscription", "Utilities", "Oct", 2026, 23.0, 0.0, false, "Planned",
                    "Google storage"));
            plans.add(createPlan("Tabby", "Credit Payback", "Oct", 2026, 28.0, 0.0, false, "Planned",
                    "Tabby installment"));
            plans.add(createPlan("Payback Ramkumar", "Credit Payback", "Oct", 2026, 50.0, 0.0, false, "Planned",
                    "Payback loan"));
            plans.add(createPlan("Sent Money to india", "Family Expense", "Oct", 2026, 3300.0, 0.0, false, "Planned",
                    "Remittance"));

            // November 2026 (Sum: 1476.31)
            plans.add(
                    createPlan("Recharge", "Utilities", "Nov", 2026, 103.5, 0.0, false, "Planned", "Monthly recharge"));
            plans.add(createPlan("Bakala", "Grocery", "Nov", 2026, 350.0, 0.0, false, "Planned", "Provisions"));
            plans.add(
                    createPlan("Laptop", "Shopping", "Nov", 2026, 748.17, 0.0, false, "Planned", "Laptop installment"));
            plans.add(createPlan("Tamara", "Credit Payback", "Nov", 2026, 25.64, 0.0, false, "Planned",
                    "Tamara installment"));
            plans.add(createPlan("Tabby", "Credit Payback", "Nov", 2026, 198.0, 0.0, false, "Planned",
                    "Tabby installment"));
            plans.add(createPlan("Google Subscription", "Utilities", "Nov", 2026, 23.0, 0.0, false, "Planned",
                    "Google subscription"));
            plans.add(createPlan("Tabby", "Credit Payback", "Nov", 2026, 28.0, 0.0, false, "Planned",
                    "Tabby installment"));

            // December 2026 (Sum: 1201.67)
            plans.add(
                    createPlan("Laptop", "Shopping", "Dec", 2026, 748.17, 0.0, false, "Planned", "Laptop installment"));
            plans.add(createPlan("Bakala", "Grocery", "Dec", 2026, 350.0, 0.0, false, "Planned", "Provisions"));
            plans.add(
                    createPlan("Recharge", "Utilities", "Dec", 2026, 103.5, 0.0, false, "Planned", "Monthly recharge"));

            // January 2027 (Sum: 1070)
            plans.add(createPlan("Bakala", "Grocery", "Jan", 2027, 350.0, 0.0, false, "Planned", "Provisions"));
            plans.add(createPlan("Samsung", "Shopping", "Jan", 2027, 616.5, 0.0, false, "Planned",
                    "Samsung device installment"));
            plans.add(
                    createPlan("Recharge", "Utilities", "Jan", 2027, 103.5, 0.0, false, "Planned", "Monthly recharge"));

            // February 2027 (Sum: 919)
            plans.add(createPlan("Samsung", "Shopping", "Feb", 2027, 919.0, 0.0, false, "Planned",
                    "Samsung installment"));

            // March 2027 (Sum: 919)
            plans.add(createPlan("Samsung", "Shopping", "Mar", 2027, 919.0, 0.0, false, "Planned",
                    "Samsung installment"));

            // April 2027 (Sum: 919)
            plans.add(createPlan("Samsung", "Shopping", "Apr", 2027, 919.0, 0.0, false, "Planned",
                    "Samsung installment"));

            repository.saveAll(plans);
            log.info("Successfully loaded {} records into 'finance_planned' collection in MongoDB.", plans.size());
        }
    }

    private FinancePlanned createPlan(String title, String category, String month, int year, double plannedAmount,
            double paidAmount, boolean isFulfilled, String status, String notes) {
        return FinancePlanned.builder()
                .title(title)
                .category(category)
                .month(month)
                .year(year)
                .plannedAmount(plannedAmount)
                .paidAmount(paidAmount)
                .isFulfilled(isFulfilled)
                .status(status)
                .currency("SAR")
                .notes(notes)
                .createdAt(Instant.now().toString())
                .build();
    }
}
