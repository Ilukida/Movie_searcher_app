package ru.kpfu.itis.vaskina.moviesearcherapp.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.GenreResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.GenreEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = MovieMapper.class, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GenreMapper {

    GenreResponse genreToGenreResponse(GenreEntity genre);

    List<GenreResponse> genreToGenreResponse(List<GenreEntity> genres);
}
