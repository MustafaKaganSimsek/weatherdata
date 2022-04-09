package com.weatherdatasystem.weatherdatasystem.sevice;

import com.weatherdatasystem.weatherdatasystem.dto.WeatherDto;
import com.weatherdatasystem.weatherdatasystem.dto.mapper.WeatherMapper;
import com.weatherdatasystem.weatherdatasystem.model.Weather;
import com.weatherdatasystem.weatherdatasystem.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    public List<WeatherDto> getWeatherForecast(){
        List<Weather> forecast = weatherRepository.findAll();

        return weatherMapper.weatherToWeatherDto(forecast);
    }
//    public List<WeatherDto> getWeatherForecastByCityName(String cityCode){
//        List<Weather> forecast = weatherRepository.findBy;
//
//        return weatherMapper.weatherToWeatherDto(forecast);
//    }
}
