package com.mahmoudi.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LibExeptionHandler {
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundExeption
            (BookNotFoundException bookNotFoundException)
    {
        LibExeption libExeption = new LibExeption(
                bookNotFoundException.getMessage(),
                bookNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(libExeption, HttpStatus.NOT_FOUND);
    }
}
