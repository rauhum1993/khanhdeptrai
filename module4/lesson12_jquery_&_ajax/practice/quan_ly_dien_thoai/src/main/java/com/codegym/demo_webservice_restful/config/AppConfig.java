package com.codegym.demo_webservice_restful.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("message/error_message");
        return messageSource;
    }

    @Bean
    public LogStudent createLogStudent() {
        return new LogStudent();
    }
}
