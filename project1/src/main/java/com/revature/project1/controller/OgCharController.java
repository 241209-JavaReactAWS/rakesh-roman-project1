package com.revature.project1.controller;

import com.revature.project1.model.OgChar;
import com.revature.project1.service.OgCharService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("characters") //Set all requests to have parent mapping http://localhost:8080/characters
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class OgCharController
{

    // TODO: implement Admin functionality
    /*
     * What can Admin do?
     * - See all characters (public and private) 
     */

    private final OgCharService ogCharService;

    @Autowired
    public OgCharController(OgCharService ogCharService){
        this.ogCharService = ogCharService;
    }

    // TODO: new character will receive its Creator field from the request, which should include {userId} as a path param
    @PostMapping("create/{userId}")
    public ResponseEntity<OgChar> createNewCharacterHandler(@RequestBody OgChar newChar, @PathVariable("userId") int userId){
        OgChar newOgChar = ogCharService.createNewCharacter(newChar, userId);
        return new ResponseEntity<>(newOgChar, HttpStatus.CREATED);
    }

    // : all user get methods will receive the {accountType} enum and {matureContentVisible} fields from the searching user to filter the search
    @GetMapping
    public List<OgChar> getAllCharactersHandler() {
        return ogCharService.getAllCharacters();
    }

    //UPDATE
    @PatchMapping
    public ResponseEntity<OgChar> updateCharacterHandler(@RequestBody OgChar updatedChar){
        OgChar updatedOgChar = ogCharService.updateCharacter(updatedChar);
        if (updatedOgChar == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(updatedOgChar, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("{characterId}")
    public void deleteCharacterHandler(HttpSession session, @PathVariable int characterId){
        String username = (String)session.getAttribute("username");
        ogCharService.deleteCharacter(characterId, username);
    }
}
