package taskr;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("tasks")
public class TaskrController {

    @Inject
    private Taskr taskr;

    @GET
    public List<Task> get() {
        return taskr.getTasks();
    }

    @POST
    public void post(Task newTask) {
        taskr.addTask(newTask);
    }

    @PUT
    public void put(Task task) {
        taskr.changeTask(task);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        taskr.delete(id);
    }
}
