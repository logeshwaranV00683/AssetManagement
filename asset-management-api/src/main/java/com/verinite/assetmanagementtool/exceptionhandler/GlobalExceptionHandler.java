package com.verinite.assetmanagementtool.exceptionhandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.putIfAbsent(((FieldError) error).getField(),error.getDefaultMessage());
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getConstraintViolations().forEach(cv -> {
            String path = cv.getPropertyPath().toString();
            errorMap.put(path, cv.getMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception ex) {

        System.out.println(ex.getClass().getName());

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDateException.class)
    public Map<String,String> handleInvalidDateException(InvalidDateException ex, HttpServletRequest req){
        Map<String,String> error=new HashMap<>();
        error.put("timestamp: ", LocalDateTime.now().toString());
        error.put("status: ",String.valueOf(HttpStatus.BAD_REQUEST.value()));
        error.put("error: ",ex.getMessage());
        error.put("path: ",req.getRequestURI());

        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String,String> handleDataIntegrityViolationException(DataIntegrityViolationException ex,HttpServletRequest req){

        Map<String,String> error=new HashMap<>();
        error.put("timestamp: ",LocalDateTime.now().toString());
        error.put("status: ",String.valueOf(HttpStatus.BAD_REQUEST.value()));
        error.put("error: ","Invalid Date Format");
        error.put("path: ",req.getRequestURI());

        return error;

    }
}
