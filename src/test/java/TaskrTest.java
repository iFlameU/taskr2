import org.junit.jupiter.api.Test;
import taskr.Task;
import taskr.Taskr;

import java.util.List;

public class TaskrTest {
    @Test
    public void test() {
        Taskr taskr = new Taskr();
        Task task = new Task();
        task.setName("Great task");
        taskr.addTask(task);
        List<Task> tasks = taskr.getTasks();
    }
}
