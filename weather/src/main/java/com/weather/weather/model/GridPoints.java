package com.weather.weather.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class GridPoints {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_day", length = 256)
    private String startDay;

    @Column(name = "start_hours", length = 256)
    private String startHours;

    @Column(name = "end_time", length = 256)
    private String endTime;

    @Column(name = "short_forecast", length = 256)
    private String shortForecast;

    @Column(name = "detailed_forecast",columnDefinition="text",length = 256)
    private String detailedForecast;

    @Column(name = "temperature", length = 256)
    private String temperature;

    @Column(name = "temperature_unit", length = 256)
    private String temperatureUnit;

    @Column(name = "city_name", length = 256)
    private String cityName;

    private String cityCode;
}
