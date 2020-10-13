package taskr;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TaskrDb {
    private static long nextId = 0;
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void changeTask(Task newTask) {
        tasks.stream().filter(t -> t.getId() == newTask.getId()).forEach(oldTask -> copyData(oldTask, newTask));
    }

    private void copyData(Task oldTask, Task newTask) {
        oldTask.setName(newTask.getName());
    }

    public synchronized void delete(long id) {
        tasks.remove(tasks.stream().filter(t -> t.getId() == id).collect(Collectors.toList()).get(0));
    }
}
