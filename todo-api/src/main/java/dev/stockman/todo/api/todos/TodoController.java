package dev.stockman.todo.api.todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAllTodos() {
        log.info("fetch all todos");
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findAll());
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> find(@PathVariable("todoId") String todoId) {
        log.info("fetch todo {}", todoId);
        return todoService.find(todoId).map(Todo -> ResponseEntity.status(HttpStatus.OK).body(Todo)).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
