package ru.kpfu.itis.vaskina.moviesearcherapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.vaskina.moviesearcherapp.api.UserApi;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.LoginRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.request.UserRequest;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.TokenCoupleResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.UserResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public UserResponse register(UserRequest userRequest) {
        return userService.register(userRequest);
    }

    @Override
    public TokenCoupleResponse login(LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @Override
    public UserResponse getByUsername(String username) {
        return null;
    }

    @Override
    public void updateImage(MultipartFile image) {
        // TODO
        userService.updateImage(null, image);
    }
}
