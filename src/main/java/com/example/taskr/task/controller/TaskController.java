package com.example.taskr.task.controller;

import com.example.taskr.task.service.TaskService;
import com.example.taskr.task.model.Task;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("tasks")
public class TaskController {

    @Inject
    private TaskService taskService;

    @GET
    public List<Task> get() {
        return taskService.getTasks();
    }

    @POST
    public void post(Task newTask) {
        taskService.addTask(newTask);
    }

    @PUT
    public void put(Task task) {
        taskService.changeTask(task);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        taskService.delete(id);
    }
}
