package com.example.taskr.task.dao;

import com.example.taskr.task.model.Task;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TaskDao {
    private static long nextId = 0;
    ArrayList<Task> tasks = new ArrayList<>();

    public Task addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void changeTask(Task newTask) {
        tasks.stream().filter(task -> task.getId() == newTask.getId()).forEach(oldTask -> copyData(oldTask, newTask));
    }

    private void copyData(Task oldTask, Task newTask) {
        oldTask.setName(newTask.getName());
    }

    public synchronized void delete(long id) {
        tasks.remove(tasks.stream().filter(task -> task.getId() == id).collect(Collectors.toList()).get(0));
    }
}
