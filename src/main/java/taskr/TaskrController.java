package taskr;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("taskr")
public class TaskrController {

    @Inject
    private Taskr taskr;

    @GET
    public List<Task> get() {
        return taskr.getTasks();
    }
}
