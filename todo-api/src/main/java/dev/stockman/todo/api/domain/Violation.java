package dev.stockman.todo.api.domain;

/**
 * Represents a single validation error or constraint violation.
 *
 * This record encapsulates details about a specific validation issue
 * encountered during input processing or object validation. It provides
 * information about the property that failed validation, the invalid value
 * associated with the property, and a message describing the violation.
 *
 * Fields:
 * - `property`: The name of the property or field that failed validation.
 * - `invalidValue`: The value of the property that did not meet the validation criteria.
 * - `message`: A descriptive message explaining the reason for the violation.
 *
 * Usage Context:
 * - Used in validation-related error responses, particularly in scenarios
 *   where multiple validation errors need to be reported.
 * - Often associated with structured error handling mechanisms to inform
 *   clients about input issues in a detailed manner.
 */
public record Violation(String property, Object invalidValue, String message) {
}
