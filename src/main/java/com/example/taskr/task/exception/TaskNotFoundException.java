package com.example.taskr.task.exception;

public class TaskNotFoundException extends RuntimeException {
    private long id;

    public TaskNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
