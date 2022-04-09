package com.weatherdatasystem.weatherdatasystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grid_points")
public class Weather {

    @Id
    private Long id;

    private String startDay;

    private String startHours;

    private String endTime;

    private String shortForecast;

    private String detailedForecast;

    private String temperature;

    private String temperatureUnit;
    private String cityCode;
}
