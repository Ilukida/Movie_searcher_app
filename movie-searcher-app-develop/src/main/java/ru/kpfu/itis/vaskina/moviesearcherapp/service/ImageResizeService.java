package ru.kpfu.itis.vaskina.moviesearcherapp.service;

import java.io.InputStream;

public interface ImageResizeService {

    InputStream resize(InputStream inputStream, int targetHeight, int targetWidth);
}
