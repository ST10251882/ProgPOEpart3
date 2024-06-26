/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart2;
import java.util.*;
/**
 *
 * @author tiffa
 */
public class Login {
    //Declare variables
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // Array to store developer names
    private static List<String> developers = new ArrayList<>();
    
    // Constructor to initialize a new Login object with user details.
    public Login(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    // Method to validate the username format.
    private boolean validateUsername() {
        // Username must contain only letters, numbers, or underscores and be no more than 20 characters in length.
        return username.matches("[a-zA-Z0-9_]+") && username.length() <= 20;
    }

    // Method to validate the password complexity.
    private boolean validatePassword() {
        // Password must be at least 8 characters long, contain a capital letter, a number, and a special character.
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    // Method to register a new user and return a welcome message.
    public String registerUser() {
        if (!validateUsername()) {
            return "Registration failed: Username is not correctly formatted. Please ensure that your username contains only letters, numbers, or underscores and is no more than 20 characters in length.";
        } else if (!validatePassword()) {
            return "Registration failed: Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
           
            return "Welcome " + firstName + " " + lastName + ", you have been registered successfully.";
        }
    }

    // Method to attempt to log in a user and return the login status.
    public String loginUser(String enteredUsername, String enteredPassword) {
        // This method  check the stored username and password against the provided credentials.
        if (this.username.equals(enteredUsername) && this.password.equals(enteredPassword)) {
            return "Welcome " + firstName + ", it is great to see you again!";
        } else {
            return "Login failed: Username or password incorrect, please try again.";
        }
    }

    // Getters methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// Method to update user details
    public void updateUserDetails(String firstName, String lastName, String username, String password) {
        if (validateUsername(username) && validatePassword(password)) {
            setFirstName(firstName);
            setLastName(lastName);
            setUsername(username);
            setPassword(password);
            System.out.println("User details updated successfully.");
        } else {
            System.out.println("Failed to update user details. Please check the username and password requirements.");
        }
    }
	 // Private helper methods to validate username and password
    private boolean validateUsername(String username) {
        // Add validation logic here
        return username.matches("[a-zA-Z0-9_]+") && username.length() <= 20;
    }
    private boolean validatePassword(String password) {
        // Add validation logic here
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    // Public method to display user information
    public void displayUserInfo() {
        System.out.println("User Information:");
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Username: " + getUsername());
        
    }
  
}
