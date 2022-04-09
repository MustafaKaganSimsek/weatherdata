package com.weather.weather.dao;

import com.weather.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository  extends JpaRepository<Weather,String> {
}
