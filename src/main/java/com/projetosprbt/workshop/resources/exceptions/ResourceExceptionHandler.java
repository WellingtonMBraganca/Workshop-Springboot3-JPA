package com.projetosprbt.workshop.resources.exceptions;

import com.projetosprbt.workshop.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

//Para este objeto interceptar as exceções e executa um possível tratamento...
@ControllerAdvice
public class ResourceExceptionHandler {

    //faz interceptar excessao e tratar conforme metodo propõe.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now()
                , status.value()
                , error
                , e.getMessage()
                , request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
