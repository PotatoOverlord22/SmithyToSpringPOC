package com.uaic.smithypoc.exception;

import com.uaic.smithypoc.generated.model.InternalServerExceptionResponseContent;
import com.uaic.smithypoc.generated.model.InvalidInputExceptionResponseContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<InvalidInputExceptionResponseContent> handleInvalidInput(IllegalArgumentException e) {
        InvalidInputExceptionResponseContent error = new InvalidInputExceptionResponseContent();
        error.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<InternalServerExceptionResponseContent> handleInternalError(RuntimeException e) {
        InternalServerExceptionResponseContent error = new InternalServerExceptionResponseContent();
        error.setMessage("Internal server error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<InternalServerExceptionResponseContent> handleGenericError(Exception e) {
        InternalServerExceptionResponseContent error = new InternalServerExceptionResponseContent();
        error.setMessage("An unexpected error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
