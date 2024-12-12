package com.microservice.stock.infrastructure.exceptionhandler;

import com.microservice.stock.domain.exceptions.AlreadyExistCategoryByName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String TIMESTAMP = "Timestamp";
    private static final String MESSAGE = "Message";
    private static final String STATUS = "status";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex){
        ArrayList<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.add(error.getDefaultMessage())
        );
        Map<String, Object> response = new HashMap<>();
        response.put(TIMESTAMP, LocalDateTime.now());
        response.put(MESSAGE, errors);
        response.put(STATUS, HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistCategoryByName.class)
    public ResponseEntity<Map<String, Object>> handleAlreadyExistCategoryByNameException(AlreadyExistCategoryByName ex){
        Map<String, Object> response = new HashMap<>();
        response.put(TIMESTAMP, LocalDateTime.now());
        response.put(MESSAGE, ex.getMessage());
        response.put(STATUS, HttpStatus.CONFLICT.toString());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
