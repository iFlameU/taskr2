package taskr;

import java.util.List;

public class Taskr {
    private TaskrDb taskrDb;

    public void addTask(Task task) {
        taskrDb.addTask(task);
    }

    public List<Task> getTasks() {
        return taskrDb.getTasks();
    }

    public void setDb(TaskrDb taskrDb) {
        this.taskrDb = taskrDb;
    }
}
