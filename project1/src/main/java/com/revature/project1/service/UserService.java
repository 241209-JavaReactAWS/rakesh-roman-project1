package com.revature.project1.service;

import com.revature.project1.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService
{
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

}
