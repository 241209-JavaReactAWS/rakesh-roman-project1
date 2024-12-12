package com.revature.project1.model;
import jakarta.persistence.*;

@Entity
@Table(name = "usercharacters")
public class OgChar {
    /*
            - id (int) (primary key)
            - name (varchar)
            - age (int)
            - description (varchar)
            - setting (varchar) (maybe hold off until later)
            - creator (varchar) (foreign key)
            - public (boolean)
            - flagFor18Plus (boolean)
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;

    private String characterName;

    private int characterAge;

    private String description;

    //Holds the userId of the user who created the character
    private int creator;

    //If true, the character will be visible to all users. If false, the character will only be visible to its creator and all admins
    private boolean isPublic;

    //If true, the character will not appear to users who do not wish to see mature content
    private boolean matureContent;

    //Constructors
    //No args constructor
    public OgChar(){};

    //Standard new character constructor
    public OgChar(String characterName, int characterAge, String description, int creator, boolean isPublic, boolean matureContent) {
        this.characterName = characterName;
        this.characterAge = characterAge;
        this.description = description;
        this.creator = creator;
        this.isPublic = isPublic;
        this.matureContent = matureContent;
    }

    //Getters and Setters
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCharacterAge() {
        return characterAge;
    }

    public void setCharacterAge(int characterAge) {
        this.characterAge = characterAge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isMatureContent() {
        return matureContent;
    }

    public void setMatureContent(boolean matureContent) {
        this.matureContent = matureContent;
    }
}