package com.example.fantazooapi.config;

import com.example.fantazooapi.service.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CageService cageService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (cageService.needsInitialization()) {
            cageService.initDB();
        }
    }
}