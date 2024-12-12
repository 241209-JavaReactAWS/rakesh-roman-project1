package com.revature.project1.service;

import com.revature.project1.dao.UserDAO;
import com.revature.project1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    //ToDo: Make banned users only visible to Admins
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    //Update a User
    public User updateUsername(User updatedUser){
        User thisUser = userDAO.findByUsername(updatedUser.getUsername());
        thisUser.setUsername(updatedUser.getUsername());
        return userDAO.save(thisUser);
    }
    //Update a user's password
    public User updatePassword(User updatedUser){
        User thisUser = userDAO.findByUsername(updatedUser.getUsername());
        thisUser.setPassword(updatedUser.getPassword());
        return userDAO.save(thisUser);
    }

    //Update a user's mature content visibility
    public User setMatureContentVisibility(User updatedUser){
        User thisUser = userDAO.findByUsername(updatedUser.getUsername());
        thisUser.setMatureContentVisible(updatedUser.isMatureContentVisible());
        return userDAO.save(thisUser);
    }

    //Ban or Unban a User
    public User moderateUser(User updatedUser){
        User targetUser = userDAO.findByUsername(updatedUser.getUsername());
        targetUser.setBanned(updatedUser.isBanned());
        return  userDAO.save(targetUser);
    }

    //Delete a User
    public void removeUser(int userId){
        userDAO.deleteById(userId);
    }

}
