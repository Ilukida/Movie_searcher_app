package ru.kpfu.itis.vaskina.moviesearcherapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "app.properties.image")
public record AppImageProperties(

        int profileImageHeight,
        int profileImageWidth,

        int genreImageHeight,
        int genreImageWidth,

        int movieImageHeight,
        int movieImageWidth,

        int personImageHeight,
        int personImageWidth
){}
