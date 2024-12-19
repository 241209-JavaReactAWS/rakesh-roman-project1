package com.revature.project1.dao;

import com.revature.project1.model.OgChar;
import com.revature.project1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OgCharDAO extends JpaRepository<OgChar, Integer>
{
    @Query("SELECT c FROM OgChar c WHERE c.characterName LIKE %:inputString% AND c.isPublic = true")
    List<OgChar> getSpecificCharactersPublic(@Param("inputString") String inputString);

    @Query("SELECT c FROM OgChar c WHERE c.characterName LIKE %:inputString% AND c.isPublic = true AND c.matureContent = false")
    List<OgChar> getSpecificCharactersPublicNotMature(@Param("inputString") String inputString);

    @Query("SELECT c FROM OgChar c WHERE c.characterName LIKE %:inputString%")
    List<OgChar> getSpecificCharactersAll(@Param("inputString") String inputString);
}
