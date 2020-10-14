package com.example.taskr.task.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.taskr.task.model.Task;
import com.example.taskr.task.service.TaskService;
import com.example.taskr.task.dao.TaskDao;

public class TaskServiceTest {

    public static final String TASK_NAME = "Great task";
    public static final String TASK_NAME_2 = "Yet another great task";

    @Test
    public void test() {
        TaskService taskService = new TaskService();
        TaskDao taskDao = new TaskDao();
        taskService.setDb(taskDao);
        Task task = new Task();
        task.setName(TASK_NAME);
        taskService.addTask(task);
        Assertions.assertTrue(taskService.getTasks().stream().anyMatch(t -> TASK_NAME.equals(t.getName())));
        TaskService taskService1 = new TaskService();
        taskService1.setDb(taskDao);
        Assertions.assertTrue(taskService1.getTasks().stream().anyMatch(t -> TASK_NAME.equals(t.getName())));
        Task taskToChange = taskService.getTasks().get(0);
        taskToChange.setName(TASK_NAME_2);
        taskService.changeTask(taskToChange);
        Assertions.assertEquals(TASK_NAME_2, taskService.getTasks().get(0).getName());
        taskService.delete(taskToChange.getId());
        Assertions.assertTrue(taskService.getTasks().stream().noneMatch(t -> t.getId() == taskToChange.getId()));
    }
}
