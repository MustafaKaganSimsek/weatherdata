package com.weatherdatasystem.weatherdatasystem.dto.mapper;

import com.weatherdatasystem.weatherdatasystem.dto.AlertCardDto;
import com.weatherdatasystem.weatherdatasystem.dto.AlertDto;
import com.weatherdatasystem.weatherdatasystem.dto.AlertMapDto;
import com.weatherdatasystem.weatherdatasystem.model.Alert;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlertMapper {

//    Alert alertDtoToAlert(AlertDto alertDto);

    AlertMapDto alertToAlertMapDto(Alert alert);
    
    List<AlertCardDto> alertToAlertCardDto(List<Alert> alert);
    List<AlertMapDto> alertToAlertMapDto(List<Alert> alert);
}
