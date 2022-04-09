package com.weatherdatasystem.weatherdatasystem.sevice;

import com.weatherdatasystem.weatherdatasystem.dto.AlertCardDto;
import com.weatherdatasystem.weatherdatasystem.dto.AlertMapDto;
import com.weatherdatasystem.weatherdatasystem.dto.mapper.AlertMapper;
import com.weatherdatasystem.weatherdatasystem.model.Alert;
import com.weatherdatasystem.weatherdatasystem.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;
    private final AlertMapper alertMapper;

//    private final WeatherRepository weatherRepository;
//    private final WeatherMapper weatherMapper;

    public List<AlertMapDto> getAlerts(){

        List<Alert> alerts = alertRepository.findAll();

        return alertMapper.alertToAlertMapDto(alerts);
    }

    public List<AlertCardDto> getAlertCardContents(){

        List<Alert> alerts = alertRepository.findAll();

        return alertMapper.alertToAlertCardDto(alerts)
                .stream()
                .filter(L-> L.getZoneId().length() == 2)
                .collect(Collectors.toList());
    }

    public List<AlertCardDto> alertFilter(AlertCardDto alertCardDto){

        String state = alertCardDto.getState();
        String event = alertCardDto.getEvent();
        String effective = alertCardDto.getEffective();
        String expires = alertCardDto.getExpires();

        return getAlertCardContents().stream()
                .filter(L-> state !="" ? L.getZoneId()==state: L.getZoneId() !="" &&
                        event !="" ? L.getEvent() == event : L.getEvent()!=""&&
                        effective !="" ? L.getEffective()==effective:L.getEffective()!=""&&
                        expires !="" ? L.getExpires() == expires : L.getExpires() !="")
                .collect(Collectors.toList());
    }
}
