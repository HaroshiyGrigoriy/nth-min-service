package com.grishiya.nth_min_service.exception.handler;

import com.grishiya.nth_min_service.exception.FileNotFoundException;
import com.grishiya.nth_min_service.exception.InvalidNAppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String fileNotFound(FileNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidNAppException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badN(InvalidNAppException ex) {
        return ex.getMessage();
    }

    /* страховка на остальные ошибки */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverError(Exception ex) {
        return "Internal error: " + ex.getMessage();
    }
}
