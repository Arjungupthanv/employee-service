package com.mall.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    record ApiError(Instant timestamp, int status, String error, String message, String path, Map<String,String> fieldErrors){}

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex, HttpServletRequest req){
        return ResponseEntity.status(404).body(new ApiError(Instant.now(),404,"Not Found",ex.getMessage(),req.getRequestURI(),null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req){
        Map<String,String> fields = ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(f->f.getField(), f->f.getDefaultMessage(), (a,b)->a));
        return ResponseEntity.badRequest().body(new ApiError(Instant.now(),400,"Bad Request","Validation failed",req.getRequestURI(),fields));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleOther(Exception ex, HttpServletRequest req){
        return ResponseEntity.status(500).body(new ApiError(Instant.now(),500,"Internal Server Error",ex.getMessage(),req.getRequestURI(),null));
    }
}
