package com.weatherdatasystem.weatherdatasystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Alerts")
@Data
public class Alert {

    @Id
    private String id;

    private String state;

    private String sent;

    private String effective;

    private String headline;

    private String expires;

    private String event;

    private String zoneId;

    private String latitude;

    private String longitude;
}
