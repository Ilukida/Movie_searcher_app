package ru.kpfu.itis.vaskina.moviesearcherapp.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageEntityService {

    void updateImage(UUID id, MultipartFile image);
}
