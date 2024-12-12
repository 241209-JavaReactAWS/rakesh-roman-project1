package com.revature.project1.controller;

import com.revature.project1.service.OgCharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("characters") //Set all requests to have parent mapping http://localhost:8080/characters
public class OgCharController
{
    private final OgCharService ogCharService;

    @Autowired
    public OgCharController(OgCharService ogCharService){
        this.ogCharService = ogCharService;
    }
}
