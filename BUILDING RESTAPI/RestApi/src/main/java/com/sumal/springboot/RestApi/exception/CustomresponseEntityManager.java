package com.sumal.springboot.RestApi.exception;

import com.sumal.springboot.RestApi.user.InvalidInputException;
import com.sumal.springboot.RestApi.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomresponseEntityManager extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<errorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
        errorDetails error = new errorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<errorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        errorDetails errorDetails = new errorDetails(LocalDate.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<errorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidInputException.class)
    public final ResponseEntity<errorDetails> handleInvalidInputException(Exception ex, WebRequest request) {
        errorDetails errorDetails = new errorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}

