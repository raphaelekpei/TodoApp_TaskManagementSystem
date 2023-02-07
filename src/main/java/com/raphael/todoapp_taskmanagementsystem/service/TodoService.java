package com.raphael.todoapp_taskmanagementsystem.service;


import com.raphael.todoapp_taskmanagementsystem.data.model.Todo;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.AddTodoRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.AddTodoResponse;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {
    AddTodoResponse addTodo(String userId, AddTodoRequest addTodoRequest);

    Todo getTodo(String todoId);

    List<Todo> getAllTodoByUserId(String userId);

    List<Todo> getAllTodos();

    void updateTodo(String userId, String todoId, String task, LocalDate deadline);

    void deleteTodo(String userId, String todoId);

    void deleteAllTodosByUserId(String userId);

    void deleteAllTodos();
}
