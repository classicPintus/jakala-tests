package com.jakala.integration;

import com.jakala.unit.simple.LocalDateComponent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class LocalDateRestController {

    private final LocalDateComponent localDateComponent;

    public LocalDateRestController(LocalDateComponent localDateComponent) {
        this.localDateComponent = localDateComponent;
    }

    @GetMapping("/difference-in-days")
    public ResponseEntity<Long> findDifferenceInDays(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate from,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate to) {
        return ResponseEntity.ok(localDateComponent.differenceInDays(from, to));
    }
}
