
package com.pmdaiclientrest.infrastructure.adapter.in.web.exception;

import com.pmdaiclientrest.domain.exception.AiProviderException;
import com.pmdaiclientrest.infrastructure.adapter.in.web.dto.HttpResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

/**
 * Global exception handler for REST API endpoints.
 * <p>
 * Converts exceptions into consistent HTTP responses with appropriate status codes.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handles AI provider exceptions
     */
    @ExceptionHandler(AiProviderException.class)
    public ResponseEntity<HttpResponse> handleAiProviderException(AiProviderException ex) {
        log.warn("AI Provider Exception: {}", ex.getMessage());
        return createResponse(HttpStatus.BAD_GATEWAY, ex.getMessage());
    }

    /**
     * Handles validation errors for request parameters and path variables.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<HttpResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.warn("Validation error: {}", ex.getMessage());
        return createResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * Handles validation errors for @Valid request bodies.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        log.warn("Request body validation failed: {}", errors);
        return createResponse(HttpStatus.BAD_REQUEST, "Request validation failed: " + errors);
    }

    /**
     * Handles constraint violations (e.g., @NotNull, @Size on method parameters).
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HttpResponse> handleConstraintViolation(ConstraintViolationException ex) {
        String errors = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));

        log.warn("Constraint violation: {}", errors);
        return createResponse(HttpStatus.BAD_REQUEST, "Constraint violation: " + errors);
    }

    /**
     * Catches all unhandled exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> handleGenericException(Exception ex) {
        log.error("Unexpected error occurred", ex);
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred. Please try again later.");
    }

    private ResponseEntity<HttpResponse> createResponse(HttpStatus status, String message) {
        HttpResponse response = HttpResponse.builder()
                .message(message)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(status).body(response);
    }
}