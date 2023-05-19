package ru.kpfu.itis.vaskina.moviesearcherapp.exception;

public class ImageNotFoundException extends NotFoundException {

    public ImageNotFoundException(){
        super("Image not found");
    }

    public ImageNotFoundException(String message) {
        super(message);
    }
}
