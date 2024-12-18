package com.revature.project1.controller;

import com.revature.project1.model.User;
import com.revature.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //CREATE
    //Register a new User
    //TODO: Name and password validation
    @PostMapping
    public ResponseEntity<User> createNewUserHandler(@RequestBody User newUser){
        // Check if username already exists for the username, and if password is longer than 4 letters
        String username = newUser.getUsername();
        String password = newUser.getPassword();
        User retrievedUser = userService.getUserByUsername(username);
        if (retrievedUser != null || password.length() < 4) {
            return ResponseEntity.badRequest().build();
        }
        User potentialUser = userService.createNewUser(newUser);
        return new ResponseEntity<>(potentialUser, HttpStatus.CREATED);
    }

    //READ
    @GetMapping
    public List<User> getAllUsersHandler(){
        return userService.getAllUsers();
    }

    //UPDATE
    //todo: many of these methods could likely be slimmed once the connection between front- and backend is understood

    //Change Username handler
    // TODO: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/change-username")
    public ResponseEntity<User> updateUsernameHandler(@RequestBody User thisUser){
        User updatedUser = userService.updateUsername(thisUser);
        // Checks if the user exists
        if (updatedUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Change Password handler
    // TODO: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/change-password")
    public ResponseEntity<User> updatePasswordHandler(@RequestBody User thisUser){
        User updatedUser = userService.updatePassword(thisUser);
        // Checks if the user exists
        if (updatedUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Change Mature Content Visibility
    // TODO: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/hide-mature-content")
    public ResponseEntity<User> setMatureContentVisibilityHandler(@RequestBody User thisUser){
        User updatedUser = userService.setMatureContentVisibility(thisUser);
        // Checks if the user exists
        if (updatedUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    
    //Ban or unban a user
    // TODO: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/moderate")
    public ResponseEntity<User> moderateUserHandler(@RequestBody User thisUser){
        User updatedUser = userService.moderateUser(thisUser);
        // Checks if the user exists
        if (updatedUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return  new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("{userId}")
    public void removeUserHandler(@PathVariable int userId){
        userService.removeUser(userId);
    }
}
