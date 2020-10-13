package taskr;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("tasks")
public class TaskrController {

    @Inject
    private Taskr taskr;

    @GET
    public List<Task> get() {
        Task task = new Task();
        task.setName("TASK_NAME");
        taskr.addTask(task);
        return taskr.getTasks();
    }
}
