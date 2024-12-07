package com.example.test.controller;

import com.example.test.model.Todo;
import com.example.test.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo addTodo(@RequestBody String title) {
        return todoService.addTodo(title);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        return todoService.updateTodo(id, updatedTodo.isCompleted()).orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }
}