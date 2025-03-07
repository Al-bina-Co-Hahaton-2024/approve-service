package ru.albina.approve.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.albina.approve.dto.response.ErrorDto;
import ru.albina.approve.exception.EntityNotFoundException;

@RestControllerAdvice
public class WebExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorDto notFound(Exception e) {
        return new ErrorDto(e.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public ErrorDto invalidData(Exception e) {
        return new ErrorDto(e.getMessage());
    }
}
