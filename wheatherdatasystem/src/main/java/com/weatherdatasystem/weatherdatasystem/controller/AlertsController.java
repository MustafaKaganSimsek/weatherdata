package com.weatherdatasystem.weatherdatasystem.controller;

import com.weatherdatasystem.weatherdatasystem.dto.AlertCardDto;
import com.weatherdatasystem.weatherdatasystem.dto.AlertMapDto;
import com.weatherdatasystem.weatherdatasystem.sevice.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AlertsController {

    private final AlertService alertService;


    @GetMapping("/alerts/map")
    public ResponseEntity<List<AlertMapDto>> getAlerts() {
        List<AlertMapDto> alerts = alertService.getAlerts();

        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/alerts/card")
    public ResponseEntity<List<AlertCardDto>> getCards() {
        List<AlertCardDto> alerts = alertService.getAlertCardContents();

        return ResponseEntity.ok(alerts);
    }

    @PostMapping("/alerts/ ")
    public ResponseEntity<List<AlertCardDto>> getFilteredCards(@RequestBody AlertCardDto alertCardDto){
        List<AlertCardDto> alerts =alertService.alertFilter(alertCardDto);
        return ResponseEntity.ok(alerts);
    }


}
