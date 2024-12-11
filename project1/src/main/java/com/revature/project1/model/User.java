package com.revature.project1.model;
import jakarta.persistence.*;

@Entity
@Table
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;

    private String password;

    //Setting this value to true allows the user to see mature content
    private boolean matureContentVisible;

    //If this value is true, the user has been banned byu an admin and is unable to access the site
    private boolean isBanned;

    //This field denotes the account type, allowing special privileges for ADMIN accounts
    private AccountType accType;
    public enum AccountType
    {
        USER,
        ADMIN;
    }


    //Constructors
    //No-args constructor
    public User() {
    }

    //Standard new account constructor
    public User(String username, String password, AccountType accType) {
        this.username = username;
        this.password = password;
        this.accType = accType;
        this.matureContentVisible = false;
        this.isBanned = false;
    }

    //Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMatureContentVisible() {
        return matureContentVisible;
    }

    public void setMatureContentVisible(boolean matureContentVisible) {
        this.matureContentVisible = matureContentVisible;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public AccountType getAccType() {
        return accType;
    }

    public void setAccType(AccountType accType) {
        this.accType = accType;
    }
}
