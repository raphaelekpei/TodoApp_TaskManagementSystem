package com.raphael.todoapp_taskmanagementsystem.service;

import com.raphael.todoapp_taskmanagementsystem.data.model.Todo;
import com.raphael.todoapp_taskmanagementsystem.data.model.User;
import com.raphael.todoapp_taskmanagementsystem.data.repository.TodoRepository;
import com.raphael.todoapp_taskmanagementsystem.data.repository.UserRepository;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.AddTodoRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.AddTodoResponse;
import com.raphael.todoapp_taskmanagementsystem.exceptions.TodoManagementException;
import com.raphael.todoapp_taskmanagementsystem.exceptions.UserManagementException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TodoRepository todoRepository;


    @Override
    public AddTodoResponse addTodo(String userId, AddTodoRequest addTodoRequest) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserManagementException("user not found");
        }
        User user = optionalUser.get();
        Todo todo = new Todo(
                addTodoRequest.getTask(),
                addTodoRequest.getDeadline()
        );
        todo.setUser(user);
        todoRepository.save(todo);
        user.getTodoList().add(todo);
        userRepository.save(user);

        AddTodoResponse addTodoResponse = new AddTodoResponse();
        addTodoResponse.setMessage("your todo was successfully created");
        return addTodoResponse;
    }

    @Override
    public Todo getTodo(String todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        if (optionalTodo.isEmpty()) {
            throw new TodoManagementException("todo does not exit");
        }
        return optionalTodo.get();
    }

    @Override
    public List<Todo> getAllTodoByUserId(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user does not exist");
        }
        return todoRepository.getAllTodosByUserId(userId);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void updateTodo(String userId, String todoId, String task, LocalDate deadline) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        User user = optionalUser.get();
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        if (optionalTodo.isEmpty()){
            throw new TodoManagementException("todo does not exist");
        }
        Todo todo = optionalTodo.get();
        if (task != null){
            todo.setTask(task);
        }
        if (deadline != null){
            todo.setDeadline(deadline);
        }
        todoRepository.save(todo);
        user.getTodoList().removeIf(foundTodo -> foundTodo.getTodoId().equals(todo.getTodoId()));
        user.getTodoList().add(todo);
        userRepository.save(user);
        // user.getTodoList().stream().filter()
    }

    @Override
    public void deleteTodo(String userId, String todoId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        User user = optionalUser.get();
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        if (optionalTodo.isEmpty()){
            throw new TodoManagementException("todo does not exist");
        }
        Todo todo = optionalTodo.get();
        todoRepository.delete(todo);
        user.getTodoList().remove(todo);
        userRepository.save(user);

    }

    @Override
    public void deleteAllTodosByUserId(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        User user = optionalUser.get();
        List<Todo> todo = todoRepository.getAllTodosByUserId(userId);
        user.getTodoList().remove(todo);
        userRepository.save(user);

    }
    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}
