package taskr;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TaskrDb {
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
