package ru.kpfu.itis.vaskina.moviesearcherapp.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.ImageMetadataResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.ImageMetadataEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ImageMetadataMapper {

    ImageMetadataResponse imageMetadataToImageMetadataResponse(ImageMetadataEntity imageMetadata);

    static String imageMetadataToImageUrl(ImageMetadataEntity imageMetadata){
        return imageMetadata.getUrl();
    }
}
