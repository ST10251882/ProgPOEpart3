/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart2;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
/**
 *
 * @author tiffa
 */
public class Task {
    //Declaring and Initiazing Variables 
    public static int taskCounter = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration; 
    private String taskID;
    private String taskStatus;

    // Arrays to store task-related data
    public static List<String> taskNames = new ArrayList<>();
    
    public static List<String> taskIDs = new ArrayList<>();
    
    public static List<Integer> taskDurations = new ArrayList<>();
    
    public static List<String> taskStatuses = new ArrayList<>();
    
    //Constructor to create a new Task instance.
    public Task(String taskName, String taskDescription, String developerFullName, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        String[] names = developerFullName.split(" ");
        this.developerFirstName = names[0];
        this.developerLastName = names.length > 1 ? names[names.length - 1] : "";
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        this.taskStatus = "To Do"; 
        
        // Populate arrays
        taskNames.add(taskName);
        taskIDs.add(this.taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(this.taskStatus);
    }

    //Checks if the task the description is 50 characters or less
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    //Generates a unique Task ID based on the task name, number, and developer's name.
    private String createTaskID() {
        String firstTwoLetters = taskName.length() > 2 ? taskName.substring(0, 2).toUpperCase(Locale.ROOT) : taskName.toUpperCase(Locale.ROOT);
        String lastThreeLetters = developerLastName.length() > 3 ? developerLastName.substring(developerLastName.length() - 3).toUpperCase(Locale.ROOT) : developerLastName.toUpperCase(Locale.ROOT);
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }

    //Prints the details of the task 
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerFirstName + " " + developerLastName + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + "hours";
    }

    //Calculates the total hours of tasks
    public static int returnTotalHours(List<Task> tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

    // Getters and Setters methods 
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
        this.taskID = createTaskID();
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    public void setDeveloperFirstName(String developerFirstName) {
        this.developerFirstName = developerFirstName;
        this.taskID = createTaskID(); 
    }

    public String getDeveloperLastName() {
        return developerLastName;
    }

    public void setDeveloperLastName(String developerLastName) {
        this.developerLastName = developerLastName;
        this.taskID = createTaskID(); 
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    public String getDeveloperName() {
        
        return this.developerFirstName + " " + this.developerLastName;
    }

   
        public void updateDeveloperDetails(String developerFullName) {
        String[] names = developerFullName.split(" ");
        this.developerFirstName = names[0];
        this.developerLastName = names.length > 1 ? names[names.length - 1] : "";
        this.taskID = createTaskID(); 
    }

        // Method to search for a task by name
    public static String searchTaskByName(String taskName) {
        
    int index = taskNames.indexOf(taskName);
    
    if (index != -1) {
        // Task found, return details
        return "Task Name: " + taskNames.get(index) +
               ", Status: " + taskStatuses.get(index);
    } else {
        // Task not found
        return "Task '" + taskName + "' not found.";
        }
    }
    
     // Method to delete a task by name
    public static boolean deleteTaskByName(String taskName) {
        int index = taskNames.indexOf(taskName);
        if (index != -1) {
            taskNames.remove(index);
            // Remove other task details from their respective lists
            return true;
        } else {
            return false;
        }
    }

    
    public void updateTaskStatus() {
        String[] statuses = {"To Do", "Done", "Doing"};
        String selectedStatus = (String) javax.swing.JOptionPane.showInputDialog(
                null,
                "Select the task status:",
                "Task Status Menu",
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                statuses,
                this.taskStatus 
        );

        if (selectedStatus != null && !selectedStatus.isEmpty()) {
            this.taskStatus = selectedStatus;
        } else {
            System.out.println("No status selected or invalid status provided.");
        }
    }

// diplaying all the tasks 
    public static void displayAllTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.printTaskDetails());
            System.out.println(); 
        }
    }

}
