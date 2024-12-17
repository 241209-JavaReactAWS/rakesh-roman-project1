package com.revature.project1.service;

import com.revature.project1.Exceptions.ContentNotFoundException;
import com.revature.project1.dao.OgCharDAO;
import com.revature.project1.model.OgChar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OgCharService
{
    private final OgCharDAO ogCharDAO;

    @Autowired
    public OgCharService(OgCharDAO ogCharDAO)
    {
        this.ogCharDAO = ogCharDAO;
    }

    //Create a New Character
    public OgChar createNewCharacter(OgChar newOgChar) {
        return ogCharDAO.save(newOgChar);
    }

    //Read Characters
    //Todo: Make an if-else control that allows only Admins to see private characters
    //Todo: Make an if-else control that hides mature content if the user's matureContentAllowed field is false
    public List<OgChar> getAllCharacters()
    {
        return ogCharDAO.findAll();
    }

    //Update a Character
    public OgChar updateCharacter(OgChar updatedCharacter){
        OgChar ogChar = ogCharDAO.findById(updatedCharacter.getCharacterId())
                .orElseThrow(() -> new ContentNotFoundException(updatedCharacter.getCharacterName() + " was not found."));

        //Set all applicable attributes of the original character to the updated values
        //Note: It is not possible to change the character's creator or the character's internal id

        //Set descriptive fields
        ogChar.setCharacterName(updatedCharacter.getCharacterName());
        ogChar.setCharacterAge(updatedCharacter.getCharacterAge());
        ogChar.setDescription(updatedCharacter.getDescription());
        //Set privacy fields
        ogChar.setMatureContent(updatedCharacter.isMatureContent());
        ogChar.setPublic(updatedCharacter.isPublic());

        //Return the saved character for later use
        return ogCharDAO.save(ogChar);
    }

    //Delete a Character
    //Todo: Make it so that only the character's creator can delete a character
    public void deleteCharacter(int characterId){
        ogCharDAO.deleteById(characterId);
    }

}
