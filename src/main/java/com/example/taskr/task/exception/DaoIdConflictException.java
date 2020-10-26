package com.example.taskr.task.exception;

import com.example.taskr.task.model.Task;

import java.util.List;

public class DaoIdConflictException extends RuntimeException{
    private List<Task> required;

    public DaoIdConflictException(List<Task> required) {
        this.required = required;
    }

    public List<Task> getRequired() {
        return required;
    }
}
