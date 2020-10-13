package taskr;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("tasks")
public class TaskrController {

    @Inject
    private TaskrService taskrService;

    @GET
    public List<Task> get() {
        return taskrService.getTasks();
    }

    @POST
    public void post(Task newTask) {
        taskrService.addTask(newTask);
    }

    @PUT
    public void put(Task task) {
        taskrService.changeTask(task);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        taskrService.delete(id);
    }
}
