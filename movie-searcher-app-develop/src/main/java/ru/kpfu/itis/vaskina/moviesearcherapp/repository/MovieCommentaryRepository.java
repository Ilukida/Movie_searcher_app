package ru.kpfu.itis.vaskina.moviesearcherapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.commentary.MovieCommentaryEntity;

import java.util.UUID;

public interface MovieCommentaryRepository extends JpaRepository<MovieCommentaryEntity, UUID> {
}
