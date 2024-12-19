package com.revature.project1.dao;

import com.revature.project1.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{
    User getUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.isBanned = false")
    List<User> getAllUnbannedUsers();

    @Query("SELECT u FROM User u WHERE u.username LIKE %:inputString% AND u.isBanned = false")
    List<User> getSpecificUsersUnbanned(@Param("inputString") String inputString);

    @Query("SELECT u FROM User u WHERE u.username LIKE %:inputString%")
    List<User> getSpecificUsersAll(@Param("inputString") String inputString);
}
