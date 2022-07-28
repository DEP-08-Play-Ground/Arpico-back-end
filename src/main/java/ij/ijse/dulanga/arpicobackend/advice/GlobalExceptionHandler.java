package ij.ijse.dulanga.arpicobackend.advice;

import ij.ijse.dulanga.arpicobackend.service.exception.DuplicateEmailException;
import ij.ijse.dulanga.arpicobackend.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateEmailException.class)
    public String handleDuplicateEmailException(DuplicateEmailException e){
        e.initCause(new ResponseStatusException(HttpStatus.CONFLICT,e.getMessage(),e));
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException e){
        e.initCause(new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e));
        return e.getMessage();
    }


}
