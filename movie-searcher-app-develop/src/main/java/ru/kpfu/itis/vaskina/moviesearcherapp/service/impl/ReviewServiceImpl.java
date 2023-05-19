package ru.kpfu.itis.vaskina.moviesearcherapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.ReviewRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.ReviewResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.exception.MovieNotFoundException;
import ru.kpfu.itis.vaskina.moviesearcherapp.exception.NotFoundException;
import ru.kpfu.itis.vaskina.moviesearcherapp.exception.UserNotFoundException;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.MovieEntity;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.ReviewEntity;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.UserEntity;
import ru.kpfu.itis.vaskina.moviesearcherapp.repository.MovieRepository;
import ru.kpfu.itis.vaskina.moviesearcherapp.repository.ReviewRepository;
import ru.kpfu.itis.vaskina.moviesearcherapp.repository.UserRepository;
import ru.kpfu.itis.vaskina.moviesearcherapp.service.ReviewService;
import ru.kpfu.itis.vaskina.moviesearcherapp.util.mapper.ReviewMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    private final MovieRepository movieRepository;

    private final ReviewMapper reviewMapper;

    @Override
    public ReviewResponse getById(UUID id) {
        return reviewMapper.toResponse(reviewRepository.findById(id).orElseThrow(() -> new NotFoundException("Review not found")));
    }

    @Transactional
    @Override
    public ReviewResponse createReview(ReviewRequest reviewRequest, UUID authorId) {
        UserEntity user = userRepository.findById(authorId).orElseThrow(UserNotFoundException::new);
        MovieEntity movie = movieRepository.findById(reviewRequest.getMovieId()).orElseThrow(MovieNotFoundException::new);
        return reviewMapper.toResponse(
                reviewRepository.save(
                        ReviewEntity.builder()
                                .rating(reviewRequest.getRating())
                                .title(reviewRequest.getTitle())
                                .review(reviewRequest.getReview())
                                .author(user)
                                .movie(movie)
                                .build())
        );
    }

    @Override
    public List<ReviewResponse> getByAuthorId(UUID authorId) {
        return reviewMapper.toResponse(reviewRepository.findAllByAuthorId(authorId));
    }
}
