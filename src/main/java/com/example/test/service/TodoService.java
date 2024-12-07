package com.example.test.service;

import com.example.test.model.Todo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo addTodo(String title) {
        Todo todo = new Todo(idCounter++, title, false);  // Mark new tasks as incomplete
        todos.add(todo);
        return todo;
    }

    public Optional<Todo> updateTodo(Long id, boolean completed) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .peek(todo -> todo.setCompleted(completed))
                .findFirst();
    }

    public boolean deleteTodo(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
}
