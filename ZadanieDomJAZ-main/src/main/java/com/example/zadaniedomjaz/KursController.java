package com.example.zadaniedomjaz;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KursController {

    private KursService kursService;

    @GetMapping("/rates/{currency}")
    public ResponseEntity<Double> getAverageRate(@PathVariable String currency,
                                                 @RequestParam(defaultValue = "1") int days) {
        double rate = kursService.calculateAverageRate(currency, days);
        return ResponseEntity.ok(rate);
    }
}
