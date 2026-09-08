package com.personaltracker.controller;

import com.personaltracker.model.DashboardSummary;
import com.personaltracker.service.ExpenseTrackerDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expense-dashboard")
@CrossOrigin(origins = "*") // For local dev
@RequiredArgsConstructor
public class ExpenseDashboardController {

    private final ExpenseTrackerDashboardService dashboardService;

    @GetMapping("/summary")
    public ResponseEntity<DashboardSummary> getSummary() {
        return ResponseEntity.ok(dashboardService.getExpenseSummary());
    }
}
