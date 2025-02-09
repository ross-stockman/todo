package dev.stockman.todo.api.todos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    private final Function<TodoEntity, Todo> toDTO = entity -> new Todo(entity.id(), entity.version(), entity.title(), entity.description());

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll().stream().map(toDTO).toList();
    }

    public Optional<Todo> find(String id) {
        return todoRepository.findById(id).map(toDTO);
    }
}
