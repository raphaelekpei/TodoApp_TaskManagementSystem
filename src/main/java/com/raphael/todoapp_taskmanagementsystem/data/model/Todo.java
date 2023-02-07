package com.raphael.todoapp_taskmanagementsystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    private String todoId;
    private String task;
    private LocalDate deadline;
    private Boolean completed = Boolean.FALSE;

    @CreatedDate
    private LocalDate createTime;
    private LocalDate updateTime;
    private User user;
    public Todo(String task, LocalDate deadline) {
        this.task = task;
        this.deadline = deadline;
    }
}
