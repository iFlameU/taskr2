package com.example.taskr.task.service;

import com.example.taskr.task.dao.DaoUtil;
import com.example.taskr.task.dao.TaskDao;
import com.example.taskr.task.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    public static final String TASK_NAME = "Great task";
    public static final String TASK_NAME_2 = "Yet another great task";
    private TaskService taskService;
    private TaskDao taskDao;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
        DaoUtil daoUtil = new DaoUtil();
        taskDao = new TaskDao();
        taskDao.setDaoUtil(daoUtil);
        taskService.setDb(taskDao);
    }

    @Test
    public void testGetTasks(){
        Assertions.assertNotNull(taskService.getTasks());
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task();
        newTask.setName(TASK_NAME);
        taskService.addTask(newTask);
        Assertions.assertTrue(taskService.getTasks().stream().anyMatch(task -> TASK_NAME.equals(task.getName())));
    }

    @Test
    public void testAddingTasksToDifferentTaskServices() {
        Task newTask = new Task();
        newTask.setName(TASK_NAME);
        taskService.addTask(newTask);
        TaskService otherTaskService = new TaskService();
        otherTaskService.setDb(taskDao);
        Assertions.assertTrue(otherTaskService.getTasks().stream().anyMatch(task -> TASK_NAME.equals(task.getName())));
    }

    @Test
    public void testChangeTask() {
        Task newTask = new Task();
        newTask.setName(TASK_NAME);
        Task taskToChange = taskService.addTask(newTask);
        taskToChange.setName(TASK_NAME_2);
        taskService.changeTask(taskToChange);
        Assertions.assertTrue(taskService.getTasks().stream().anyMatch(task -> task.getName().equals(TASK_NAME_2)));
    }

    @Test
    public void testDeleteTask() {
        Task newTask = new Task();
        newTask.setName(TASK_NAME);
        Task taskToChange = taskService.addTask(newTask);
        taskService.delete(taskToChange.getId());
        Assertions.assertTrue(taskService.getTasks().stream().noneMatch(task -> task.getId() == taskToChange.getId()));
    }
}
