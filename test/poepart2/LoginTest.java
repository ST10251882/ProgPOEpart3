/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package poepart2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiffa
 */

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        // Initialize a Login object with the provided details before each test
        login = new Login("Nic", "Ken", "kly_1", "Ch&&sec@ke99!");
    }

    @Test
    public void testRegisterUser_Success() {
        // Test successful registration
        String expected = "Welcome Nic Ken, you have been registered successfully.";
        String actual = login.registerUser();
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginUser_Success() {
        // Test successful login
        String expected = "Welcome Nic, it is great to see you again!";
        String actual = login.loginUser("kly_1", "Ch&&sec@ke99!");
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginUser_Failure() {
        // Test login failure due to incorrect credentials
        String expected = "Login failed: Username or password incorrect, please try again.";
        String actual = login.loginUser("kly_1", "incorrectPassword");
        assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName() {
        // Test setting first name
        login.setFirstName("NewName");
        assertEquals("NewName", login.getFirstName());
    }

    @Test
    public void testSetLastName() {
        // Test setting last name
        login.setLastName("NewLastName");
        assertEquals("NewLastName", login.getLastName());
    }

    @Test
    public void testSetUsername() {
        // Test setting username
        login.setUsername("new_username");
        assertEquals("new_username", login.getUsername());
    }

    @Test
    public void testSetPassword() {
        // Test setting password
        login.setPassword("NewP@ssw0rd!");
        assertEquals("NewP@ssw0rd!", login.getPassword());
    }

    @Test
    public void testUpdateUserDetails_Success() {
        // Test updating user details successfully
        login.updateUserDetails("UpdatedName", "UpdatedLastName", "updated_username", "UpdatedP@ssw0rd!");
        assertEquals("UpdatedName", login.getFirstName());
        assertEquals("UpdatedLastName", login.getLastName());
        assertEquals("updated_username", login.getUsername());
        assertEquals("UpdatedP@ssw0rd!", login.getPassword());
    }

}
