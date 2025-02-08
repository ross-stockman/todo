package dev.stockman.todo.api.domain;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * A generator for producing unique string-based identifiers.
 *
 * This class utilizes UUIDs to ensure uniqueness and implements the {@code Supplier<String>} interface,
 * which allows it to generate string representations of unique identifiers upon invocation.
 *
 * Use cases:
 * - Can be used in applications requiring unique keys or request IDs.
 * - Useful for tracking or correlation purposes in distributed systems.
 *
 * The generated identifiers are guaranteed to be universally unique as per UUID specifications.
 */
public class UniqueIdentityGenerator implements Supplier<String> {
    @Override
    public String get() {
        return UUID.randomUUID().toString();
    }
}
