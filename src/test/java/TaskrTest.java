import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import taskr.Task;
import taskr.Taskr;

import java.util.List;

public class TaskrTest {

    public static final String TASK_NAME = "Great task";

    @Test
    public void test() {
        Taskr taskr = new Taskr();
        Task task = new Task();
        task.setName(TASK_NAME);
        taskr.addTask(task);
        List<Task> tasks = taskr.getTasks();
        Assertions.assertTrue(tasks.stream().anyMatch(t -> TASK_NAME.equals(t.getName())));
    }
}
