package com.revature.project1.dao;

import com.revature.project1.model.OgChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgCharDAO extends JpaRepository<OgChar, Integer>
{

}
