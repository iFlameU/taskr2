package com.example.taskr.task.dao;

import com.example.taskr.task.exception.DaoIdConflictException;
import com.example.taskr.task.exception.TaskNotFoundException;
import com.example.taskr.task.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoUtil {

    Task find(ArrayList<Task> tasks, long id) {
        List<Task> required = tasks.stream().filter(task -> task.getId() == id).collect(Collectors.toList());
        if(required.size() == 1) {
            return required.get(0);
        } else if (required.size() > 1) {
            throw new DaoIdConflictException(required);
        } else {
            throw new TaskNotFoundException(id);
        }
    }
}
