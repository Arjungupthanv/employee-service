package com.mall.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple root controller so visiting "/" gives a friendly response.
 */
@RestController
public class RootController {

    @GetMapping("/")
    public ResponseEntity<Object> root() {
        return ResponseEntity.ok(
            java.util.Map.of(
                "app", "Employee Service",
                "status", "running",
                "endpoints", java.util.List.of("/api/v1/employees")
            )
        );
    }
}
