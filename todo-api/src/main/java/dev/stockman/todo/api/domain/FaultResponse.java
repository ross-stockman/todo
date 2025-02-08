package dev.stockman.todo.api.domain;

/**
 * Represents a response object for reporting fault or error information.
 *
 * This record encapsulates a single field, {@code error}, which contains
 * a description of the error or fault that occurred. It is commonly used in
 * error handling scenarios to provide structured and meaningful feedback
 * to clients, particularly in exception handlers.
 *
 * Usage Context:
 * - Used in conjunction with {@code GlobalExceptionHandler} methods
 *   to generate consistent error responses for various types of exceptions.
 * - Enables clients to understand the nature of the issue through
 *   a descriptive error message.
 *
 * Typical scenarios include:
 * - Responding with an error message for unhandled exceptions.
 * - Indicating issues such as malformed JSON requests, unsupported media types,
 *   or HTTP method violations.
 */
public record FaultResponse(String error) {
}