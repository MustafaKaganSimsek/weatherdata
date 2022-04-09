package com.weather.weather.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "alerts")
public class Weather {
    @Id
    @Column(name = "id",length = 128)
    private String id;
    @Column(name = "sent",length = 128)
    private String sent;
    @Column(name = "effective",length = 128)
    private String effective;
    @Column(name = "expires",length = 128)
    private String expires;
    @Column(name = "event",length = 128)
    private String event;

    @Column(name = "zoneId",length = 2)
    private String zoneId;

    @Column(name = "latitude",length = 32)
    private String latitude;

    @Column(name = "longitude",length = 32)
    private String longitude;

    @Column(name = "state",length = 32)
    private String state;

   // @Lob
   // @Column(name = "description",length = 100000)
   // private String description;

    //@Lob
    //@Column(name = "instruction",length = 100000)
    //private String instruction;

    //@Lob
    //@Column(name = "areaDesc",length = 100000)
    //private String areaDesc;

    @Transient
    private GeoCode geocode;
    private String headline;


}
