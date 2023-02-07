package com.raphael.todoapp_taskmanagementsystem.controller;

import com.raphael.todoapp_taskmanagementsystem.data.model.Todo;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.AddTodoRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.AddTodoResponse;

import java.time.LocalDate;
import java.util.List;

public interface TodoController {

    public AddTodoResponse addTodo(String userId, AddTodoRequest addTodoRequest);

    public Todo getTodo(String todoId);
    public List<Todo> getAllTodosByUserId(String userId);
    public List<Todo> getAllTodos();

    public String updateTodo(String userId, String todoId, String content, LocalDate deadline);
    public String deleteTodo(String userId, String todoId);
    public String deleteAllTodosByUserId(String userId);
    public String deleteAllTodos();


}
