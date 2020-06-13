package com.abdulmansour.springboot.demo.rest;

import com.abdulmansour.springboot.demo.entity.Developer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RESTController {

    @Value("${developer.firstName}")
    private String firstName;

    @Value("${developer.lastName}")
    private String lastName;

    @GetMapping("/")
    public String index() {
        return "Hello world! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/dev")
    public Developer dev() {
        Developer developer = new Developer(firstName, lastName);
        return developer;
    }

}
