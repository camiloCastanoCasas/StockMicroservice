package com.microservice.stock.infrastructure.exceptionhandler;

import com.microservice.stock.domain.exceptions.AlreadyExistCategoryByName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationExceptions(MethodArgumentNotValidException ex){
        ArrayList<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.add(error.getDefaultMessage())
        );
        Map<String, Object> response = new HashMap<>();
        response.put("Timestamp", LocalDateTime.now().toString());
        response.put("Message", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistCategoryByName.class)
    public ResponseEntity<Map<String, Object>> handleAlreadyExistCategoryByNameException(AlreadyExistCategoryByName ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("Message", ex.getMessage()));
    }
}
