package com.product.service.resources.exceptions;

import com.product.service.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/*The @ControllerAdvice annotation will intercept the
    error and pass it to the object for handling*/

@ControllerAdvice
public class ResourceExceptionHandler {

    /*The @ExceptionHandler annotation will intercept
    the thrown exception(ResourceNotFoundException) inside the
    method and will perform the error handling*/

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(),
                error,e.getMessage(), request.getRequestURI());
        //Using status.value() to convert Object of type HttpStatus to integer
        return ResponseEntity.status(status).body(standardError);
    }
}
