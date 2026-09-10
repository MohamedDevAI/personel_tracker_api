package com.personaltracker.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> getHealth() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "personal-tracker-backend");
        status.put("database", "MongoDB Atlas");
        status.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(status);
    }
}
