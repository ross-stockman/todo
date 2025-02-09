package dev.stockman.todo.api.todos;

import jakarta.validation.constraints.NotNull;

public record Todo(
        @NotNull String id,
        @NotNull Integer version,
        @NotNull String title,
        String description
) {
}
