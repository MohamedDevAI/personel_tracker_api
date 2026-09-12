package com.personaltracker.controller;

import com.personaltracker.model.BorrowRepayRecord;
import com.personaltracker.service.BorrowRepayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/borrow-repay", "/api/borrow_repay"})
@RequiredArgsConstructor
public class BorrowRepayController {

    private final BorrowRepayService service;

    @GetMapping
    public ResponseEntity<List<BorrowRepayRecord>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowRepayRecord> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/creditor/{creditorName}")
    public ResponseEntity<List<BorrowRepayRecord>> getByCreditor(@PathVariable String creditorName) {
        return ResponseEntity.ok(service.getByCreditorName(creditorName));
    }

    @PostMapping
    public ResponseEntity<BorrowRepayRecord> create(@RequestBody BorrowRepayRecord record) {
        return ResponseEntity.ok(service.save(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowRepayRecord> update(@PathVariable String id, @RequestBody BorrowRepayRecord record) {
        record.setId(id);
        return ResponseEntity.ok(service.save(record));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
