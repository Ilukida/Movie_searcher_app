package ru.kpfu.itis.vaskina.moviesearcherapp.exception;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(){
        super("User not found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
