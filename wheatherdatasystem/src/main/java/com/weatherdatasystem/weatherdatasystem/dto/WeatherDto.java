package com.weatherdatasystem.weatherdatasystem.dto;

import lombok.Data;

@Data
public class WeatherDto {

    private String startDay;

    private String startHours;

    private String endTime;

    private String shortForecast;

    private String detailedForecast;

    private String temperature;

    private String temperatureUnit;
    private String cityCode;
}
