package ru.kpfu.itis.vaskina.moviesearcherapp.service;

import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.ReviewRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.ReviewResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface ReviewService {

    ReviewResponse getById(UUID id);

    @Transactional
    ReviewResponse createReview(ReviewRequest reviewRequest, UUID authorId);

    List<ReviewResponse> getByAuthorId(UUID authorId);
}
