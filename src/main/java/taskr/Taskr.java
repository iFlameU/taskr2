package taskr;

import javax.inject.Inject;
import java.util.List;

public class Taskr {
    private TaskrDb taskrDb;

    @Inject
    public void setDb(TaskrDb taskrDb) {
        this.taskrDb = taskrDb;
    }

    public void addTask(Task task) {
        taskrDb.addTask(task);
    }

    public List<Task> getTasks() {
        return taskrDb.getTasks();
    }

    public void changeTask(Task task) {
        taskrDb.changeTask(task);
    }

    public void delete(long id) {
        taskrDb.delete(id);
    }
}
