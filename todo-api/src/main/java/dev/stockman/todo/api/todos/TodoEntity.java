package dev.stockman.todo.api.todos;

public record TodoEntity(
        String id,
        Integer version,
        String title,
        String description
) {
}
