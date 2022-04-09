package com.weatherdatasystem.weatherdatasystem.repository;

import com.weatherdatasystem.weatherdatasystem.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Long> {
}
