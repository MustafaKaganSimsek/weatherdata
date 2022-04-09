package com.weatherdatasystem.weatherdatasystem.dto.mapper;

import com.weatherdatasystem.weatherdatasystem.dto.WeatherDto;
import com.weatherdatasystem.weatherdatasystem.model.Weather;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    List<WeatherDto> weatherToWeatherDto(List<Weather> weather);

}
