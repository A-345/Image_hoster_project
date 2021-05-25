package com.upgrad.technical.api;


import com.upgrad.technical.service.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceConfiguration.class)
public class TechnicalApiApplication {


    public static void main(String[] args) {

        SpringApplication.run(TechnicalApiApplication.class, args);
    }
}
