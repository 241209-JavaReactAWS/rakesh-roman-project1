package com.revature.project1.controller;

import com.revature.project1.model.OgChar;
import com.revature.project1.service.OgCharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("characters") //Set all requests to have parent mapping http://localhost:8080/characters
public class OgCharController
{
    private final OgCharService ogCharService;

    @Autowired
    public OgCharController(OgCharService ogCharService){
        this.ogCharService = ogCharService;
    }

    //todo: new character will receive its Creator field from the request, which should include {userId} as a path param
    @PostMapping
    public ResponseEntity<OgChar> createNewCharacterHandler(@RequestBody OgChar newChar){
        OgChar newOgChar = ogCharService.createNewCharacter(newChar);
        return new ResponseEntity<>(newOgChar, HttpStatus.CREATED);
    }

    //todo: all user get methods will receive the {accountType} enum and {matureContentVisible} fields from the searching user to filter the search
    @GetMapping
    public List<OgChar> getAllCharactersHandler(){
        return ogCharService.getAllCharacters();
    }

    //UPDATE: Need to solve error 415 with POST before this can be implemented
    @PatchMapping
    public ResponseEntity<OgChar> updateCharacterHandler(@RequestBody OgChar updatedChar){
        OgChar updatedOgChar = ogCharService.updateCharacter(updatedChar);
        return new ResponseEntity<>(updatedOgChar, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("{characterId}")
    public void deleteCharacterHandler(@PathVariable int characterId){
        ogCharService.deleteCharacter(characterId);
    }
}
