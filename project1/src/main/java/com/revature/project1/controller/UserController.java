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
    //todo: Name and password validation
    @PostMapping
    public ResponseEntity<User> createNewUserHandler(@RequestBody User newUser){
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
    //todo: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/change-username")
    public ResponseEntity<User> updateUsernameHandler(@RequestBody User thisUser){
        User updatedUser = userService.updateUsername(thisUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    //Change Password handler
    //todo: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/change-password")
    public ResponseEntity<User> updatePasswordHandler(@RequestBody User thisUser){
        User updatedUser = userService.updatePassword(thisUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    //Change Mature Content Visibility
    //todo: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/hide-mature-content")
    public ResponseEntity<User> setMatureContentVisibilityHandler(@RequestBody User thisUser){
        User updatedUser = userService.setMatureContentVisibility(thisUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    //Ban or unban a user
    //todo: handle null response case. should not happen in practice, but good to cover
    @PatchMapping("my-profile/moderate")
    public ResponseEntity<User> moderateUserHandler(@RequestBody User thisUser){
        User updatedUser = userService.moderateUser(thisUser);
        return  new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    //Delete
    @DeleteMapping("{userId}")
    public void removeUserHandler(@PathVariable int userId){
        userService.removeUser(userId);
    }
}
