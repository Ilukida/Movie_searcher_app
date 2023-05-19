package ru.kpfu.itis.vaskina.moviesearcherapp.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AppImageProperties.class)
public class AppConfig {
}
