package com.weatherdatasystem.weatherdatasystem.model;

import lombok.Data;
import net.bytebuddy.utility.RandomString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "Customer")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "first_name",length = 64,nullable = false)
    private String firstName;

    @Column(name = "second_name",length = 64,nullable = false)
    private String secondName;

    @Column(name = "location",length = 64,nullable = false)
    private String location;

    @Column(name = "email",length = 64,nullable = false)
    private String email ;

    @Column(name = "phone_number",length = 16,nullable = true)
    private String phoneNumber;

//

//    @Column(name = "creating_date",length = 64,nullable = false,updatable = false)
//    private String creatingDate;
//
//    @Column(name = "verification_token",length = 64,nullable = false,updatable = false)
//    private String verificationToken;


//    public void setVerificationToken(){
//        this.verificationToken = RandomString.make(64);
//    }
//
//    public void setCreatingDate() {
//        LocalDateTime myDateObj = LocalDateTime.now();
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        creatingDate = myDateObj.format(myFormatObj);
//    }
}
