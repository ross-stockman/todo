package dev.stockman.todo.api.domain;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Arrays;

/**
 * Centralized exception handler for handling application-wide exceptions
 * in a uniform and consistent manner.
 *
 * This class uses Spring's {@code @ControllerAdvice} to intercept
 * and manage exceptions thrown by controllers.
 *
 * Exception handling includes:
 * - General exceptions
 * - Handling of malformed JSON requests
 * - Validation errors for method arguments
 * - Unsupported media type errors
 * - Handling of non-existent resource access
 * - Unsupported HTTP request methods
 *
 * Each handler method logs appropriate error details and generates
 * a structured response to send back to the client.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String REQUEST_ID_HEADER = "x-request-id";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FaultResponse> handleException(Exception ex, HttpServletResponse response) {
        logger.error("Exception handler caught an unhandled exception", ex);
        String responseBody = "An error occurred. Please use this request ID for tracking: " + response.getHeader(REQUEST_ID_HEADER);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FaultResponse(responseBody));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<FaultResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String responseBody = "Malformed JSON request";
        logger.info(responseBody);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FaultResponse(responseBody));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ViolationsResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.info("Invalid request");
        var violations = ex.getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getRejectedValue(), error.getDefaultMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ViolationsResponse(violations));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<FaultResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        String responseBody = String.format("The media type '%s' is not supported. Supported media types are: %s.",
                ex.getContentType(),
                ex.getSupportedMediaTypes());
        logger.info(responseBody);
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(new FaultResponse(responseBody));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<FaultResponse> handleNoResourceFoundException() {
        logger.info("Resource not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<FaultResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        String responseBody = String.format("The request method '%s' is not supported. Supported request methods are: %s.", ex.getMethod(), Arrays.toString(ex.getSupportedMethods()));
        logger.info("Request method not supported");
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new FaultResponse(responseBody));
    }
}
