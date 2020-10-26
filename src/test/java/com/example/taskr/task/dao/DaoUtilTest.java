package com.example.taskr.task.dao;

import com.example.taskr.task.exception.DaoIdConflictException;
import com.example.taskr.task.exception.TaskNotFoundException;
import com.example.taskr.task.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

public class DaoUtilTest {

    private DaoUtil daoUtil;

    @BeforeEach
    public void setUp() {
        daoUtil = new DaoUtil();
    }

    @Test
    public void expectedSuccessfullyFromFind() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(0, "Alpha"));
        tasks.add(new Task(1, "Beta"));
        Assertions.assertEquals("Beta", daoUtil.find(tasks, 1).getName());
    }

    @Test
    public void notFound() {
        Assertions.assertThrows(TaskNotFoundException.class, () -> daoUtil.find(new ArrayList<>(), 3));
    }

    @Test
    public void multipleSameIds() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(0, "Alpha"));
        tasks.add(new Task(0, "Beta"));
        Assertions.assertThrows(DaoIdConflictException.class, () -> daoUtil.find(tasks, 0));
    }
}
