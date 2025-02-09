package dev.stockman.todo.api.todos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<TodoEntity> todoEntityRowMapper = (rs, _) -> new TodoEntity(
            rs.getString("id"),
            rs.getInt("version"),
            rs.getString("title"),
            rs.getString("description"));

    public TodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TodoEntity> findAll() {
        String sql = "SELECT * FROM todo";
        return jdbcTemplate.query(sql, todoEntityRowMapper);
    }

    public Optional<TodoEntity> findById(String id) {
        String sql = "SELECT * FROM todo WHERE id = ?";
        return jdbcTemplate.query(sql, todoEntityRowMapper, id).stream().findFirst();
    }
}
