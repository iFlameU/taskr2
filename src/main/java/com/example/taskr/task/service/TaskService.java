package com.example.taskr.task.service;

import com.example.taskr.task.dao.TaskDao;
import com.example.taskr.task.model.Task;

import javax.inject.Inject;
import java.util.List;

public class TaskService {
    private TaskDao taskDao;

    @Inject
    public void setDb(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public Task addTask(Task task) {
        return taskDao.addTask(task);
    }

    public List<Task> getTasks() {
        return taskDao.getTasks();
    }

    public void changeTask(Task task) {
        taskDao.changeTask(task);
    }

    public void delete(long id) {
        taskDao.delete(id);
    }
}
