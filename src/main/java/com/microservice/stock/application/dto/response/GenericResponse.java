package com.microservice.stock.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GenericResponse {
    private final String message;
    private final String status;
    private final LocalDateTime timestamp;
}
