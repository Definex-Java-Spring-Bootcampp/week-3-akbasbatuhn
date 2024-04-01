package com.patika.productservice.exception;

import com.patika.productservice.dto.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(
            ResourceNotFoundException exception, WebRequest request
    ) {
        log.error("Exception occurred. {}", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(createErrorDTO(exception, request));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(
            ResourceNotFoundException exception, WebRequest request
    ) {
        log.error("Exception occurred. {}", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(createErrorDTO(exception, request));
    }

    private ErrorResponseDTO createErrorDTO(
            ResourceNotFoundException exception, WebRequest request
    ) {
        return ErrorResponseDTO.builder()
                .errorCode(HttpStatus.NOT_FOUND)
                .errorMessage(exception.getMessage())
                .apiPath(request.getDescription(false))
                .errorTimestamp(LocalDateTime.now())
                .build();
    }
}
