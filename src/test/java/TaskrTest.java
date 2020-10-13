import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import taskr.Task;
import taskr.Taskr;
import taskr.TaskrDb;

public class TaskrTest {

    public static final String TASK_NAME = "Great task";
    public static final String TASK_NAME_2 = "Yet another great task";

    @Test
    public void test() {
        Taskr taskr = new Taskr();
        TaskrDb taskrDb = new TaskrDb();
        taskr.setDb(taskrDb);
        Task task = new Task();
        task.setName(TASK_NAME);
        taskr.addTask(task);
        Assertions.assertTrue(taskr.getTasks().stream().anyMatch(t -> TASK_NAME.equals(t.getName())));
        Taskr taskr1 = new Taskr();
        taskr1.setDb(taskrDb);
        Assertions.assertTrue(taskr1.getTasks().stream().anyMatch(t -> TASK_NAME.equals(t.getName())));
        Task taskToChange = taskr.getTasks().get(0);
        taskToChange.setName(TASK_NAME_2);
        taskr.changeTask(taskToChange);
        Assertions.assertEquals(TASK_NAME_2, taskr.getTasks().get(0).getName());
    }
}
