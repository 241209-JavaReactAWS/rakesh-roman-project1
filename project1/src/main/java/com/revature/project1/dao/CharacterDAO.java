package com.revature.project1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDAO extends JpaRepository<Character, Integer>
{

}
