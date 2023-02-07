package com.raphael.todoapp_taskmanagementsystem.controller;


import com.raphael.todoapp_taskmanagementsystem.data.model.Todo;
import com.raphael.todoapp_taskmanagementsystem.data.repository.TodoRepository;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.AddTodoRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.AddTodoResponse;
import com.raphael.todoapp_taskmanagementsystem.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoControllerImpl implements TodoController{

    @Autowired
    private final TodoService todoService;
    @Autowired
    private TodoRepository todoRepository;

    @Override
    @PostMapping("/new")
    public AddTodoResponse addTodo(String userId, AddTodoRequest addTodoRequest) {
        return null;
    }

    @Override
    @GetMapping("/get/{todoId}")
    public Todo getTodo(@PathVariable String todoId) {
        return todoService.getTodo(todoId);
    }

    @Override
    @GetMapping("/all/{userId}")
    public List<Todo> getAllTodosByUserId(@PathVariable String userId) {
        return todoService.getAllTodoByUserId(userId);
    }

    @Override
    @GetMapping("/get/all")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @Override
    @PutMapping("/update/{userId}/{todoId}")
    public String updateTodo(
            @PathVariable String userId,
            @PathVariable String todoId,
            @RequestParam String task,
            @RequestParam LocalDate deadline) {
            todoService.updateTodo(userId, todoId, task, deadline);
        return "Updated Successfully";
    }


    @Override
    @DeleteMapping("/delete/{userId}/{todoId}")
    public String deleteTodo(@PathVariable String userId, @PathVariable String todoId) {
        todoService.deleteTodo(userId, todoId);
        return "deleted successfully";
    }

    @Override
    @DeleteMapping("/delete/{userId}")
    public String deleteAllTodosByUserId(@PathVariable String userId) {
        todoService.deleteAllTodosByUserId(userId);
        return "deleted successfully";
    }

    @Override
    @DeleteMapping("/delete/all")
    public String deleteAllTodos() {
        todoService.deleteAllTodos();
        return "deleted successfully";
    }
}
