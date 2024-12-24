package com.Dushxn.GoldenScrolls.Controller;

import com.Dushxn.GoldenScrolls.Model.User;
import com.Dushxn.GoldenScrolls.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user: " + e.getMessage());
        }
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found: " + e.getMessage());
        }
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            userService.updateUser(id, user);
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to update user: " + e.getMessage());
        }
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete user: " + e.getMessage());
        }
    }
}
