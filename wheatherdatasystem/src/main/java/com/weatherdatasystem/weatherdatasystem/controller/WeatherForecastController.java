package com.weatherdatasystem.weatherdatasystem.controller;

import com.weatherdatasystem.weatherdatasystem.dto.AlertCardDto;
import com.weatherdatasystem.weatherdatasystem.dto.WeatherDto;
import com.weatherdatasystem.weatherdatasystem.sevice.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WeatherForecastController {

    private final WeatherService weatherService;


    @GetMapping("/forecast/card")
    public ResponseEntity<List<WeatherDto>> getCards() {
        List<WeatherDto> forecasts = weatherService.getWeatherForecast();

        return ResponseEntity.ok(forecasts);
    }


}
