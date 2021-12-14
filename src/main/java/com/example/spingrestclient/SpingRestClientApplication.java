package com.example.spingrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class SpingRestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingRestClientApplication.class, args);
    }

}
