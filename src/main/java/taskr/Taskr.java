package taskr;

import java.util.ArrayList;
import java.util.List;

public class Taskr {
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
