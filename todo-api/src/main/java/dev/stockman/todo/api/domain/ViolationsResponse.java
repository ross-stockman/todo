package dev.stockman.todo.api.domain;

import java.util.List;

/**
 * Represents a response object containing a list of validation errors or constraint violations.
 *
 * This record encapsulates multiple {@code Violation} instances, each providing details about
 * specific validation issues encountered during request processing or object validation.
 *
 * Use cases:
 * - Typically used in error responses for APIs to report multiple validation errors in a structured format.
 * - Frequently returned by exception handlers, such as in cases where method argument validation fails.
 *
 * Fields:
 * - `violations`: A list of {@code Violation} objects, with each object representing a single validation error.
 *
 * Typical scenarios include:
 * - Providing detailed feedback to client applications on why their input was rejected.
 * - Aggregating multiple validation errors in a single response to improve client-side error handling.
 */
public record ViolationsResponse(List<Violation> violations) {
}
