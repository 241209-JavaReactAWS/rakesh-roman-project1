package com.revature.project1.service;

import com.revature.project1.Exceptions.ContentNotFoundException;
import com.revature.project1.dao.OgCharDAO;
import com.revature.project1.dao.UserDAO;
import com.revature.project1.model.OgChar;
import com.revature.project1.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OgCharService {
    private final OgCharDAO ogCharDAO;
//    private final UserDAO userDAO;

    //    public OgCharService(OgCharDAO ogCharDAO, UserDAO userDAO)
    @Autowired
    public OgCharService(OgCharDAO ogCharDAO, UserDAO userDAO) {
        this.ogCharDAO = ogCharDAO;
//        this.userDAO = userDAO;
    }

    //Create a New Character
    public OgChar createNewCharacter(OgChar newOgChar) {
        return ogCharDAO.save(newOgChar);
    }

    //Read Characters
    // TODO: Make an if-else control that allows only Admins to see private characters
    // TODO: Make an if-else control that hides mature content if the user's matureContentAllowed field is false
    public List<OgChar> getAllCharacters() {
        return ogCharDAO.findAll();
    }

    //Update a Character
    public OgChar updateCharacter(OgChar updatedCharacter) {
        OgChar ogChar = ogCharDAO.findById(updatedCharacter.getCharacterId())
                .orElseThrow(() -> new ContentNotFoundException(updatedCharacter.getCharacterName() + " was not found."));

        //Set all applicable attributes of the original character to the updated values
        //Note: It is not possible to change the character's creator or the character's internal id

        //Set descriptive fields
        ogChar.setCharacterName(updatedCharacter.getCharacterName());
        ogChar.setCharacterAge(updatedCharacter.getCharacterAge());
        ogChar.setCharacterSetting(updatedCharacter.getCharacterSetting());
        ogChar.setDescription(updatedCharacter.getDescription());
        //Set privacy fields
        ogChar.setMatureContent(updatedCharacter.isMatureContent());
        ogChar.setPublic(updatedCharacter.isPublic());

        //Return the saved character for later use
        return ogCharDAO.save(ogChar);
    }

    //Delete a Character.
    // TODO: Make it so that only the character's creator can delete a character
    public void deleteCharacter(int characterId, String username) {
//        // Get the character and the user trying to delete it
//        User retrievedUser = userDAO.getUserByUsername(username);
//        Optional<OgChar> retrievedCharacter = ogCharDAO.findById(characterId);
//        // Check if the character exists
//        if (retrievedCharacter.isPresent()) {
//            OgChar character = retrievedCharacter.get();
//            // If the user's id is the same as the character's creator id, then delete it
//            if (retrievedUser.getUserId() == character.getCreator()) {
//                ogCharDAO.deleteById(characterId);
//            }
//        }
    }

//    public List<User> getSpecificCharactersPublic(String input) {
//        return ogCharDAO.getSpecificCharactersPublic(input);
//    }
//
//    public List<User> getSpecificCharactersAll(String input) {
//        return ogCharDAO.getSpecificCharactersAll(input);
//    }
}
