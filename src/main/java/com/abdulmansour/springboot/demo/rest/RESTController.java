package com.abdulmansour.springboot.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RESTController {

    @GetMapping("/")
    public String index() {
        return "Hello world! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/marathon")
    public String marathon() {
        return "Run a 5k marathon!";
    }

}
