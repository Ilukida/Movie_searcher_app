package ru.kpfu.itis.vaskina.moviesearcherapp.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.CommentaryRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.MovieRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.CommentaryResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.MovieResponse;

import java.util.UUID;

@RequestMapping("/api/v1/movies")
public interface MovieApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Page<MovieResponse> getAll(Pageable pageable);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/byGenre/{genreId}")
    Page<MovieResponse> getAllByGenreId(@PathVariable UUID genreId);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    MovieResponse create(@RequestBody MovieRequest movieRequest);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/image")
    void updateImage(@PathVariable UUID id, MultipartFile image);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/commentary")
    CommentaryResponse createCommentary(@PathVariable UUID id, @RequestBody CommentaryRequest commentaryRequest);
}
