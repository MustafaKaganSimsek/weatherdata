package com.weatherdatasystem.weatherdatasystem.dto;

import lombok.Data;

@Data
public class AlertCardDto {


    private String effective;

    private String state;

    private String headline;

    private String expires;

    private String event;

    private String zoneId;



}
