package com.personaltracker.controller;

import com.personaltracker.model.PlannedRepayment;
import com.personaltracker.service.PlannedRepaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/planned-repayments", "/api/planned_repayments"})
@RequiredArgsConstructor
public class PlannedRepaymentController {

    private final PlannedRepaymentService service;

    @GetMapping
    public ResponseEntity<List<PlannedRepayment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlannedRepayment> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlannedRepayment> create(@RequestBody PlannedRepayment plan) {
        return ResponseEntity.ok(service.save(plan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlannedRepayment> update(@PathVariable String id, @RequestBody PlannedRepayment plan) {
        plan.setId(id);
        return ResponseEntity.ok(service.save(plan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
