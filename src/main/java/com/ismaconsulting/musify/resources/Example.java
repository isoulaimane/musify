package com.ismaconsulting.musify.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Example {

    @GetMapping("/test")
    public String test() {
        return "7";
    }

}
