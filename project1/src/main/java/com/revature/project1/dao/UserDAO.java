package com.revature.project1.dao;

import com.revature.project1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{
    User findByUsername(String username);
}
