/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart2;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiffa
 */
public class PoePart2 {  
    /**
     * @param args the command line arguments
     */
    
    // Declare taskList as a static variable if it needs to be accessed in a static context
    private static List<Task> taskList = new ArrayList<>();
    

    public static void main(String[] args) {
        // Prompt the user for login details and create a new login object
        String firstName = JOptionPane.showInputDialog("Please enter your first name:");
        
        String lastName = JOptionPane.showInputDialog("Please enter your last name:");
        
        String username = JOptionPane.showInputDialog("Please enter your username:");
        
        String password = JOptionPane.showInputDialog("Please enter your password:");
        
        Login login = new Login(firstName, lastName, username, password);

        
        // Initialize arrays to store task-related data
        List<String> developers = new ArrayList<>();
        
        List<String> taskNames = new ArrayList<>();
        
        List<String> taskIDs = new ArrayList<>();
        
        List<Integer> taskDurations = new ArrayList<>();
        
        List<String> taskStatuses = new ArrayList<>();

        
        // Display a welcome message to the user
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        
        // Flag to control the main application loop
        boolean running = true;

        
        // Main application loop
        while (running) {
            // Display a menu of options and capture the user's choice
            String input = JOptionPane.showInputDialog(null,
                    "Choose an option:\n" +
                            "1) Add tasks\n" +
                            "2) Show report\n" +
                            "3) Search for a task\n" +
                            "4) Delete a task\n" +
                            "5) Update task status \n" +
                            "6) Quit");
            int choice = Integer.parseInt(input);
            
            // Handle the user's menu selection
            switch (choice) {
                case 1:
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));
                    for (int i = 0; i < numTasks; i++) {
                        // Prompt the user for task details and create a new Task object
                        String taskName = JOptionPane.showInputDialog("Enter the name of task " + (i + 1) + ":");
                        
                        String taskDescription = JOptionPane.showInputDialog("Enter a short description for task " + (i + 1) + ":");
                        
                        String developerName = JOptionPane.showInputDialog("Enter the first and last name of the developer assigned to task " + (i + 1) + ":");
                        
                        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the estimated duration of the task in hours:"));

                        Task task = new Task(taskName, taskDescription, developerName, taskDuration);
                        if (task.checkTaskDescription()) {
                            taskList.add(task);
                            developers.add(developerName);
                            taskNames.add(taskName);
                            taskIDs.add(task.getTaskID());
                            taskDurations.add(taskDuration);
                            taskStatuses.add(task.getTaskStatus());
                            
                            JOptionPane.showMessageDialog(null, "Task successfully captured\n" + task.printTaskDetails());
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                        }
                    }
                    break;
                case 2:
                    // Display the report (full details of all captured tasks)
                    Task.displayAllTasks(taskList);
                    break;
                case 3:
                    String developerName = JOptionPane.showInputDialog("Enter the developer's name to search for their tasks:");
                    
                    List<Task> tasksByDeveloper = searchTasksByDeveloper(developerName);
                    
                    StringBuilder sb = new StringBuilder();
                    
                    for (Task task : tasksByDeveloper) {
                        sb.append(task.printTaskDetails()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    
                    break;
                    
                case 4:
                    String taskNameToDelete = JOptionPane.showInputDialog("Enter the name of the task to delete:");
                    
                    if (deleteTaskByName(taskNameToDelete)) {
                        
                        JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Task not found.");
                    }
                    
                    break;
                    
                case 5:
                    String taskNameToUpdate = JOptionPane.showInputDialog("Enter the name of the task to update its status:");
                    Task taskToUpdate = findTaskByName(taskNameToUpdate);
                        if (taskToUpdate != null) {
                            String[] possibleStatuses = {"To Do", "Doing", "Done"};
                            String newStatus = (String) JOptionPane.showInputDialog(null,"Select the new status for the task: ","Update Task Status",JOptionPane.QUESTION_MESSAGE,null,possibleStatuses,taskToUpdate.getTaskStatus());
                        if (newStatus != null) {
                            taskToUpdate.setTaskStatus(newStatus);
                            JOptionPane.showMessageDialog(null, "Task status updated to: " + newStatus);
                        } else {
                            JOptionPane.showMessageDialog(null, "Task status update cancelled.");
                        }
                        } else {
                            JOptionPane.showMessageDialog(null, "Task not found.");
                        }
                    break;
                    
                case 6:
                    // Display the total hours for all tasks if any tasks were added
                    if (!taskList.isEmpty()) {
                        
                        int totalHours = Task.returnTotalHours(taskList);
                        
                        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours + " hours");
                    }
                    running = false;
                    
                    JOptionPane.showMessageDialog(null, "Exiting the application. Goodbye!");
                    
                    break;
                default:
                    
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    
                    break;
            }
        }
         
    }
    
    // New method to search a task by developer name
      private static List<Task> searchTasksByDeveloper(String developerName) {
        List<Task> tasksForDeveloper = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDeveloperName().equalsIgnoreCase(developerName)) {
                tasksForDeveloper.add(task);
            }
        }
        return tasksForDeveloper;
    }
      
    // New method to delete a task by name        
    private static boolean deleteTaskByName(String taskName) {
        boolean isDeleted = false;
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTaskName().equalsIgnoreCase(taskName)) {
                taskList.remove(i);
                isDeleted = true;
                break; // Task found and deleted, exit the loop
            }
        }
        return isDeleted;
    }
            
    // New method to find a task by name
    private static Task findTaskByName(String taskName) {
        for (Task task : taskList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return task;
            }
        }
        return null; // Task not found
    }

    
}
    

