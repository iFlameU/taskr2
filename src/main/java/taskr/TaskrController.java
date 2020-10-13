package taskr;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
}
