package com.revature.project1.service;

import com.revature.project1.dao.UserDAO;
import com.revature.project1.model.User;
import com.revature.project1.model.User.AccountType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    //Create a new User
    public User createNewUser(User newUser){
        return userDAO.save(newUser);
    }

    //Read Users
    // TODO: Make banned users only visible to Admins
    // String param username
    public List<User> getAllUsers(){
//        // Check if the user is an admin. If so, show everyone
//        User thisUser = userDAO.getUserByUsername(username);
//        if (thisUser == null) {
//            // User doesn't exist
//            return null;
//        }
//        // Check if the user is an Admin
//        else if (thisUser.getAccType() == AccountType.ADMIN) {
//            // Show all users (banned and unbanned)
//            return userDAO.findAll();
//        }
//        // The user is NOT an admin
//        else {
//            // Only show unbanned users
//            return userDAO.getAllUnbannedUsers();
//        }

        return userDAO.findAll();
    }

    // Find User by Username
    public User getUserByUsername(String username) { return userDAO.getUserByUsername(username); }

    //Update a user's Username
    public User updateUsername(User updatedUser){
        Optional<User> thisUser = userDAO.findById(updatedUser.getUserId());
        if(thisUser.isPresent()) {
            thisUser.get().setUsername(updatedUser.getUsername());
            return userDAO.save(thisUser.get());
        }
        else
            return null;
    }
    //Update a user's password
    public User updatePassword(User updatedUser){
        Optional<User> thisUser = userDAO.findById(updatedUser.getUserId());
        if(thisUser.isPresent()) {
            thisUser.get().setPassword(updatedUser.getPassword());
            return userDAO.save(thisUser.get());
        }
        else
            return null;
    }

    //Update a user's mature content visibility
    public User setMatureContentVisibility(User updatedUser){
        Optional<User> thisUser = userDAO.findById(updatedUser.getUserId());
        if (thisUser.isPresent()) {
            User user = thisUser.get();
            user.setMatureContentVisible(updatedUser.isMatureContentVisible());
            return userDAO.save(thisUser.get());
        }
        else {
            return null;
        }    
    }

    // TODO: add a check to ensure only an admin can ban users
    //Ban or Unban a User
    public User moderateUser(User updatedUser){
        Optional<User> thisUser = userDAO.findById(updatedUser.getUserId());
        // if(thisUser.isPresent()) {
        //     thisUser.get().setBanned(updatedUser.isBanned());
        //     return userDAO.save(thisUser.get());
        // }
        if (thisUser.isPresent()) {
            User user = thisUser.get();
            if (user.getAccType() == AccountType.ADMIN) {
                user.setBanned(updatedUser.isBanned());
                return userDAO.save(thisUser.get());
            }
        }
        return null;
    }

    //Delete a User
    // TODO: Only an admin should be able to delete users that are not themselves
    //      A user should be able to delete their own account and No One Else's
    public void removeUser(int userId){
        Optional<User> retrievedUser = userDAO.findById(userId);
        if (retrievedUser.isPresent()) {
            User user = retrievedUser.get();
            if (user.getAccType() == AccountType.ADMIN || user.getUserId() == userId) {
                userDAO.deleteById(userId);
            }
        }
    }

}
