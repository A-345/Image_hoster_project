package com.upgrad.technical.service;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.upgrad.technical.service")
@EntityScan("com.upgrad.technical.service.entity")
public class ServiceConfiguration {
}
