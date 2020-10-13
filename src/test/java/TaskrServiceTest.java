import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import taskr.Task;
import taskr.TaskrService;
import taskr.TaskrDb;

public class TaskrServiceTest {

    public static final String TASK_NAME = "Great task";
    public static final String TASK_NAME_2 = "Yet another great task";

    @Test
    public void test() {
        TaskrService taskrService = new TaskrService();
        TaskrDb taskrDb = new TaskrDb();
        taskrService.setDb(taskrDb);
        Task task = new Task();
        task.setName(TASK_NAME);
        taskrService.addTask(task);
        Assertions.assertTrue(taskrService.getTasks().stream().anyMatch(t -> TASK_NAME.equals(t.getName())));
        TaskrService taskrService1 = new TaskrService();
        taskrService1.setDb(taskrDb);
        Assertions.assertTrue(taskrService1.getTasks().stream().anyMatch(t -> TASK_NAME.equals(t.getName())));
        Task taskToChange = taskrService.getTasks().get(0);
        taskToChange.setName(TASK_NAME_2);
        taskrService.changeTask(taskToChange);
        Assertions.assertEquals(TASK_NAME_2, taskrService.getTasks().get(0).getName());
        taskrService.delete(taskToChange.getId());
        Assertions.assertTrue(taskrService.getTasks().stream().noneMatch(t -> t.getId() == taskToChange.getId()));
    }
}
