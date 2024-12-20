package com.revature.project1.service;

import com.revature.project1.dao.OgCharDAO;
import com.revature.project1.dao.UserDAO;
import com.revature.project1.model.OgChar;
import com.revature.project1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserDAO userDAO;
    private final OgCharDAO ogCharDAO;

    @Autowired
    public UserService(UserDAO userDAO, OgCharDAO ogCharDAO)
    {
        this.userDAO = userDAO;
        this.ogCharDAO = ogCharDAO;
    }

    //Create a new User
    public User createNewUser(User newUser){
        return userDAO.save(newUser);
    }

    //Read Users
    // String param username
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    // Find User by Username
    public User getUserByUsername(String username) { return userDAO.getUserByUsername(username); }

    //Update a user's Username
    public User updateUsername(User updatedUser){
        Optional<User> thisUser = userDAO.findById(updatedUser.getUserId());
        if (thisUser.isPresent()) {
            thisUser.get().setUsername(updatedUser.getUsername());
            return userDAO.save(thisUser.get());
        }
        else
            return null;
    }
    //Update a user's password
    public User updatePassword(User updatedUser){
        Optional<User> thisUser = userDAO.findById(updatedUser.getUserId());
        if (thisUser.isPresent()) {
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
            if (user.getAccType() == User.AccountType.ADMIN) {
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
            if (user.getAccType() == User.AccountType.ADMIN || user.getUserId() == userId) {
                userDAO.deleteById(userId);
            }
        }
    }

    public List<User> getSpecificUsersUnbanned(String input) {
        return userDAO.getSpecificUsersUnbanned(input);
    }

    public List<User> getSpecificUsersAll(String input) {
        return userDAO.getSpecificUsersAll(input);
    }

    public List<OgChar> getSpecificCharacters(String input, String username) {
        // Check if user is an Admin or not
        User user = getUserByUsername(username);
        if (user.getAccType() == User.AccountType.USER) {
            // Can only see public characters
            if (user.isMatureContentVisible()) {
                return ogCharDAO.getSpecificCharactersPublic(input);
            }
            return ogCharDAO.getSpecificCharactersPublicNotMature(input);
        }
        // Can see all characters (public and private)
        return ogCharDAO.getSpecificCharactersAll(input);
    }

    public User getUserById(int id, String username) {
        User user = getUserByUsername(username);
        if (user.getAccType() == User.AccountType.USER) {
            // Can only see unbanned users
//            return ogCharDAO.getSpecificCharactersPublicNotMature(input);
            return userDAO.getUserUnbanned(id);
        }
        // Can see all users (banned and unbanned)
//        return ogCharDAO.getSpecificCharactersAll(input);
        Optional<User> potentialUser = userDAO.findById(id);
        if (potentialUser.isPresent()) {
            return potentialUser.get();
        }
        return null;
    }
}
