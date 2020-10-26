package com.example.taskr.task.dao;

import com.example.taskr.task.model.Task;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TaskDao {
    private static long nextId = 0;
    ArrayList<Task> tasks = new ArrayList<>();

    private DaoUtil daoUtil;

    @Inject
    public void setDaoUtil(DaoUtil daoUtil) {
        this.daoUtil = daoUtil;
    }

    public Task addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void changeTask(Task newTask) {
        Task oldTask = daoUtil.find(tasks, newTask.getId());
        copyData(oldTask, newTask);
    }

    private void copyData(Task oldTask, Task newTask) {
        oldTask.setName(newTask.getName());
    }

    public synchronized void delete(long id) {
        tasks.remove(daoUtil.find(tasks, id));
    }
}
