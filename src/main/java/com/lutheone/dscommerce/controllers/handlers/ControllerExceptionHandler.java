package com.lutheone.dscommerce.controllers.handlers;

import com.lutheone.dscommerce.dto.CustomError;
import com.lutheone.dscommerce.services.exceptions.DataBaseExeception;
import com.lutheone.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> handleResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), String.valueOf(status.value()), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseExeception.class)
    public ResponseEntity<CustomError> handleDataBaseException(DataBaseExeception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), String.valueOf(status.value()), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
