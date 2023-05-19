package ru.kpfu.itis.vaskina.moviesearcherapp.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.ReviewResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.ReviewEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = MovieMapper.class, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewMapper {

    ReviewResponse toResponse(ReviewEntity review);

    List<ReviewResponse> toResponse(List<ReviewEntity> review);
}
