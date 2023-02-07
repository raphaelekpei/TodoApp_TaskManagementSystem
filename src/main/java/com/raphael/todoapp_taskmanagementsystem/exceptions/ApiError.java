package com.raphael.todoapp_taskmanagementsystem.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Getter
// @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private boolean isSuccessful;
    private LocalDateTime timeStamp;
    private String message;
}
