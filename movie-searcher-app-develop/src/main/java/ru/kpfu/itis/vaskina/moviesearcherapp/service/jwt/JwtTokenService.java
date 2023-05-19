package ru.kpfu.itis.vaskina.moviesearcherapp.service.jwt;

import ru.kpfu.itis.vaskina.moviesearcherapp.dto.TokenCoupleDto;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.TokenCoupleResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.UserResponse;

public interface JwtTokenService {

    TokenCoupleResponse generateToken(UserResponse userResponse);

    TokenCoupleResponse refreshAccessToken(TokenCoupleDto tokenCoupleDto);
}
