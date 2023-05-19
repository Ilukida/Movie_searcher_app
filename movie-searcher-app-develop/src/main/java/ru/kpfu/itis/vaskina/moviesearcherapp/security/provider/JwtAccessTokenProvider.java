package ru.kpfu.itis.vaskina.moviesearcherapp.security.provider;

import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.UserResponse;

import java.time.Instant;

public interface JwtAccessTokenProvider {

    String generateToken(UserResponse userResponse);

    UserResponse userInfoByToken(String accessToken);

    Instant getExpiration(String accessToken);
}
