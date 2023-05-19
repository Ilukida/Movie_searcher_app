package ru.kpfu.itis.vaskina.moviesearcherapp.exception;

public class MovieNotFoundException extends NotFoundException {

    public MovieNotFoundException(){
        super("Movie not found");
    }

    public MovieNotFoundException(String message) {
        super(message);
    }
}
