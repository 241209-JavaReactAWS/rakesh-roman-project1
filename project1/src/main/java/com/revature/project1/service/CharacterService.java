package com.revature.project1.service;

import com.revature.project1.dao.CharacterDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class CharacterService
{
    private final CharacterDAO characterDAO;

    @Autowired
    public CharacterService(CharacterDAO characterDAO)
    {
        this.characterDAO = characterDAO;
    }

}
