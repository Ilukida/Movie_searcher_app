package ru.kpfu.itis.vaskina.moviesearcherapp.service;

import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.LoginRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.UserRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.TokenCoupleResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.UserResponse;

public interface UserService extends ImageEntityService {

    UserResponse getByUsername(String username);

    UserResponse register(UserRequest userRequest);

    TokenCoupleResponse login(LoginRequest loginRequest);
}
