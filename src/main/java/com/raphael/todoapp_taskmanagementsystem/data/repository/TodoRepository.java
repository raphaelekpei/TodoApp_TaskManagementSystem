package com.raphael.todoapp_taskmanagementsystem.data.repository;

import com.raphael.todoapp_taskmanagementsystem.data.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> getAllTodosByUserId(String userId);

}
