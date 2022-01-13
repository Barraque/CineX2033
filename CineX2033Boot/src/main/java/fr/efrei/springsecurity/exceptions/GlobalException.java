package fr.efrei.springsecurity.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.NoSuchElementException;

@ControllerAdvice(value = "fr.efrei.springsecurity.controllers")
public class GlobalException  extends  Exception{

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(
            final NoSuchElementException nsee
    ) {
        return new ResponseEntity<>(
                "Resource not found : " + nsee.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity<String> badDataException(
           String msg) {
        return new ResponseEntity<>(
               msg,
                HttpStatus.BAD_REQUEST
        );
    }
}
