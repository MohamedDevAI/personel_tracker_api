package com.personaltracker.controller;

import com.personaltracker.model.FinancePlanned;
import com.personaltracker.service.FinancePlannedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/finance_planned", "/api/finance-planned"})
@RequiredArgsConstructor
public class FinancePlannedController {

    private final FinancePlannedService service;

    @GetMapping
    public ResponseEntity<List<FinancePlanned>> getAll(
            @RequestParam(required = false) String month,
            @RequestParam(required = false) Integer year) {
        return ResponseEntity.ok(service.getByMonthAndYear(month, year));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancePlanned> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FinancePlanned> create(@RequestBody FinancePlanned plan) {
        return ResponseEntity.ok(service.save(plan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancePlanned> update(@PathVariable String id, @RequestBody FinancePlanned plan) {
        plan.setId(id);
        return ResponseEntity.ok(service.save(plan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
