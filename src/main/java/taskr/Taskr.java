package taskr;

import javax.inject.Inject;
import java.util.List;

public class Taskr {
    private TaskrDb taskrDb;

    public void addTask(Task task) {
        taskrDb.addTask(task);
    }

    public List<Task> getTasks() {
        return taskrDb.getTasks();
    }

    public void changeTask(Task task) {
        taskrDb.changeTask(task);
    }

    @Inject
    public void setDb(TaskrDb taskrDb) {
        this.taskrDb = taskrDb;
    }
}
