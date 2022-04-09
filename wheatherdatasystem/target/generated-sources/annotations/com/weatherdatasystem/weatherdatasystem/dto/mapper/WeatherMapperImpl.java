package com.weatherdatasystem.weatherdatasystem.dto.mapper;

import com.weatherdatasystem.weatherdatasystem.dto.WeatherDto;
import com.weatherdatasystem.weatherdatasystem.model.Weather;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-14T11:38:13+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class WeatherMapperImpl implements WeatherMapper {

    @Override
    public List<WeatherDto> weatherToWeatherDto(List<Weather> weather) {
        if ( weather == null ) {
            return null;
        }

        List<WeatherDto> list = new ArrayList<WeatherDto>( weather.size() );
        for ( Weather weather1 : weather ) {
            list.add( weatherToWeatherDto1( weather1 ) );
        }

        return list;
    }

    protected WeatherDto weatherToWeatherDto1(Weather weather) {
        if ( weather == null ) {
            return null;
        }

        WeatherDto weatherDto = new WeatherDto();

        weatherDto.setStartDay( weather.getStartDay() );
        weatherDto.setStartHours( weather.getStartHours() );
        weatherDto.setEndTime( weather.getEndTime() );
        weatherDto.setShortForecast( weather.getShortForecast() );
        weatherDto.setDetailedForecast( weather.getDetailedForecast() );
        weatherDto.setTemperature( weather.getTemperature() );
        weatherDto.setTemperatureUnit( weather.getTemperatureUnit() );
        weatherDto.setCityCode( weather.getCityCode() );

        return weatherDto;
    }
}
