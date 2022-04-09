package com.weatherdatasystem.weatherdatasystem.dto.mapper;

import com.weatherdatasystem.weatherdatasystem.dto.AlertCardDto;
import com.weatherdatasystem.weatherdatasystem.dto.AlertMapDto;
import com.weatherdatasystem.weatherdatasystem.model.Alert;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-14T11:38:12+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class AlertMapperImpl implements AlertMapper {

    @Override
    public AlertMapDto alertToAlertMapDto(Alert alert) {
        if ( alert == null ) {
            return null;
        }

        AlertMapDto alertMapDto = new AlertMapDto();

        alertMapDto.setState( alert.getState() );
        alertMapDto.setLatitude( alert.getLatitude() );
        alertMapDto.setLongitude( alert.getLongitude() );

        return alertMapDto;
    }

    @Override
    public List<AlertCardDto> alertToAlertCardDto(List<Alert> alert) {
        if ( alert == null ) {
            return null;
        }

        List<AlertCardDto> list = new ArrayList<AlertCardDto>( alert.size() );
        for ( Alert alert1 : alert ) {
            list.add( alertToAlertCardDto1( alert1 ) );
        }

        return list;
    }

    @Override
    public List<AlertMapDto> alertToAlertMapDto(List<Alert> alert) {
        if ( alert == null ) {
            return null;
        }

        List<AlertMapDto> list = new ArrayList<AlertMapDto>( alert.size() );
        for ( Alert alert1 : alert ) {
            list.add( alertToAlertMapDto( alert1 ) );
        }

        return list;
    }

    protected AlertCardDto alertToAlertCardDto1(Alert alert) {
        if ( alert == null ) {
            return null;
        }

        AlertCardDto alertCardDto = new AlertCardDto();

        alertCardDto.setEffective( alert.getEffective() );
        alertCardDto.setState( alert.getState() );
        alertCardDto.setHeadline( alert.getHeadline() );
        alertCardDto.setExpires( alert.getExpires() );
        alertCardDto.setEvent( alert.getEvent() );
        alertCardDto.setZoneId( alert.getZoneId() );

        return alertCardDto;
    }
}
