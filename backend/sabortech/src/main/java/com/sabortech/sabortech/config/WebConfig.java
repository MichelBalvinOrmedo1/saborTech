package com.sabortech.sabortech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequestMapping("/api/v1")
public class WebConfig implements WebMvcConfigurer {
    // Puedes agregar configuraciones adicionales aquí si es necesario
}