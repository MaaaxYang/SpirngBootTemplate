package com.ryan.atom.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ControllerAspectConfig {
    @Bean
    public ControllerAspect controllerAspect()
    {
        return new ControllerAspect();
    }
}
