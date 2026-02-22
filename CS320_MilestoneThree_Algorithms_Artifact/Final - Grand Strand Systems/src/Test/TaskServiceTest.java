package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.TaskService;

class TaskServiceTest {

    @Test
    @DisplayName("Add and Get Task by returned ID")
    void testAddAndGetTask() {
        TaskService service = new TaskService();
        String id = service.addTask("Task Name", "Description");
        assertNotNull(service.getTask(id));
        assertEquals("Task Name", service.getTask(id).getTaskName());
    }

    @Test
    @DisplayName("Update Task Name by ID")
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        String id = service.addTask("Task Name", "Description");
        service.updateTaskName("Updated Task Name", id);
        assertEquals("Updated Task Name", service.getTask(id).getTaskName());
    }

    @Test
    @DisplayName("Update Task Description by ID")
    void testUpdateTaskDesc() {
        TaskService service = new TaskService();
        String id = service.addTask("Task Name", "Description");
        service.updateTaskDesc("Updated Description", id);
        assertEquals("Updated Description", service.getTask(id).getTaskDesc());
    }

    @Test
    @DisplayName("Delete Task by ID")
    void testDeleteTask() {
        TaskService service = new TaskService();
        String id = service.addTask("Task Name", "Description");
        service.deleteTask(id);
        assertNull(service.getTask(id));
        assertEquals(0, service.size());
    }
}