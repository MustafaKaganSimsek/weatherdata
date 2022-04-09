package com.weatherdatasystem.weatherdatasystem.controller;

import com.weatherdatasystem.weatherdatasystem.dto.UserDto;
//import com.weatherdatasystem.weatherdatasystem.sevice.Customer.CustomerServise;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mail")
@AllArgsConstructor
public class CustomerController {
//    private  final CustomerServise customerServise;
//
//    @PostMapping()
//    public UserDto register(@RequestBody UserDto userDto,HttpServletRequest request){
//        customerServise.register(userDto, getSiteURL(request));
//        return userDto;
//    }
//
//    private String getSiteURL(HttpServletRequest request) {
//        String siteURL = request.getRequestURL().toString();
//        return siteURL.replace(request.getServletPath(), "");
//    }
}
