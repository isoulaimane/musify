package com.ismaconsulting.musify.resources;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaconsulting.musify.meteo.MeteoCalculator;

@RestController
public class Example {



    @Inject
    MeteoCalculator calculator;


    @GetMapping("/test")
    public String test(){

        return calculator.calculMeteo() + "";
    }
}
