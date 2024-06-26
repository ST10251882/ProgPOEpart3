/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poepart2;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author tiffa
 */
public class TaskTest {
    
   @Test
    public void testTaskCreationAndIDGeneration() {
        // Create tasks using the test data
        Task task1 = new Task("Create Login", "Login functionality", "Mike Smith", 5);
        Task task2 = new Task("Create Add Features", "Add new features", "Edward Harrison", 8);
        Task task3 = new Task("Create Reports", "Generate reports", "Samantha Paulson", 2);
        Task task4 = new Task("Add Arrays", "Work with arrays", "Glenda Oberholzer", 11);

        // Check if the tasks have been created with correct IDs
        assertEquals("CR:1:ITH", task1.getTaskID());
        assertEquals("CR:2:SON", task2.getTaskID());
        assertEquals("CR:3:SON", task3.getTaskID());
        assertEquals("AD:4:ZER", task4.getTaskID());
    }

    @Test
    public void testTotalHoursCalculation() {
        // Create a list of tasks
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Create Login", "Login functionality", "Mike Smith", 5));
        tasks.add(new Task("Create Add Features", "Add new features", "Edward Harrison", 8));
        tasks.add(new Task("Create Reports", "Generate reports", "Samantha Paulson", 2));
        tasks.add(new Task("Add Arrays", "Work with arrays", "Glenda Oberholzer", 11));

        // Calculate total hours
        int totalHours = Task.returnTotalHours(tasks);

        // Check if the total hours are calculated correctly
        assertEquals(26, totalHours);
    }
    @Test
    public void testUpdateTaskStatus() {
        // Create a task
        Task task = new Task("Create Login", "Login functionality", "Mike Smith", 5);
        
        // Update the task status
        task.setTaskStatus("Doing");
        
        // Check if the status is updated correctly
        assertEquals("Doing", task.getTaskStatus());
    }

    @Test
    public void testCheckTaskDescription() {
        // Create a task with a short description
        Task taskShortDesc = new Task("Create Login", "Login", "Mike Smith", 5);
        
        // Create a task with a long description
        Task taskLongDesc = new Task("Create Login", "This is a very long task description that exceeds the 50 characters limit", "Mike Smith", 5);
        
        // Check if the descriptions are validated correctly
        assertTrue(taskShortDesc.checkTaskDescription());
        assertFalse(taskLongDesc.checkTaskDescription());
    }

    @Test
    public void testSearchTaskByName() {
        // Create tasks using the test data
        Task task1 = new Task("Create Login", "Login functionality", "Mike Smith", 5);
        Task task2 = new Task("Create Add Features", "Add new features", "Edward Harrison", 8);
        
        // Populate the arrays
        Task.taskNames.add(task1.getTaskName());
        Task.taskNames.add(task2.getTaskName());
        Task.taskStatuses.add(task1.getTaskStatus());
        Task.taskStatuses.add(task2.getTaskStatus());
        
        // Search for an existing task
        String searchResult1 = Task.searchTaskByName("Create Login");
        
        // Search for a non-existing task
        String searchResult2 = Task.searchTaskByName("Non-Existing Task");
        
        // Check if the search results are correct
        assertEquals("Task Name: Create Login, Status: To Do", searchResult1);
        assertEquals("Task 'Non-Existing Task' not found.", searchResult2);
    }
    
}