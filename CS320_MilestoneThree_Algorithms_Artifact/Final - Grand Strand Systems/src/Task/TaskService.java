/*************************
 * Artifact Enhancement for CS 499 (Algorithms & Data Structures)
 * Enhancement: Replace ArrayList + linear search (O(n)) with HashMap lookup (avg O(1))
 *************************/

package Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    // Enhancement: HashMap provides average O(1) add/get/update/delete by ID
    private final Map<String, Task> tasksById = new HashMap<>();

    // Display all tasks (order not guaranteed; use sorted method below if needed)
    public void displayTaskList() {
        for (Task task : tasksById.values()) {
            System.out.println("\t Task ID: " + task.getTaskID());
            System.out.println("\t Task Name: " + task.getTaskName());
            System.out.println("\t Task Description: " + task.getTaskDesc());
        }
    }

    // Adds a new task and RETURNS its generated ID (helps tests and calling code)
    public String addTask(String taskName, String taskDesc) {
        Task task = new Task(taskName, taskDesc);
        String id = task.getTaskID();

        // Defensive check (IDs should be unique, but this prevents overwrites)
        if (tasksById.containsKey(id)) {
            throw new IllegalStateException("Duplicate Task ID generated: " + id);
        }

        tasksById.put(id, task);
        return id;
    }

    // Get a task by ID (returns null if not found)
    public Task getTask(String taskID) {
        return tasksById.get(taskID);
    }

    // Delete a task by ID
    public void deleteTask(String taskID) {
        Task removed = tasksById.remove(taskID);
        if (removed == null) {
            System.out.println("Task ID: " + taskID + " not found.");
        }
    }

    // Update the task name by ID
    public void updateTaskName(String updatedString, String taskID) {
        Task task = tasksById.get(taskID);
        if (task != null) {
            task.setTaskName(updatedString);
        } else {
            System.out.println("Task ID: " + taskID + " not found.");
        }
    }

    // Update the task description by ID
    public void updateTaskDesc(String updatedString, String taskID) {
        Task task = tasksById.get(taskID);
        if (task != null) {
            task.setTaskDesc(updatedString);
        } else {
            System.out.println("Task ID: " + taskID + " not found.");
        }
    }

    // Optional Enhancement: Return tasks sorted by name (uses Comparator)
    public List<Task> getTasksSortedByName() {
        List<Task> list = new ArrayList<>(tasksById.values());
        Collections.sort(list, Comparator.comparing(Task::getTaskName));
        return list;
    }

    // Helpful utility for tests
    public int size() {
        return tasksById.size();
    }
}