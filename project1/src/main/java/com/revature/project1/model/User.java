package com.revature.project1.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String pfp;

    private String username;

    private String password;

    //Setting this value to true allows the user to see mature content
    private boolean matureContentVisible;

    //If this value is true, the user has been banned byu an admin and is unable to access the site
    private boolean isBanned;

    //This field denotes the account type, allowing special privileges for ADMIN accounts
    private AccountType accType;
    //Note: This field is represented within the database as a TinyInt
    //ADMIN = 0
    //USER = 1
    public enum AccountType
    {
        ADMIN,
        USER;
    }


    //Constructors
    //No-args constructor
    public User() {
    }

    //2 arg account constructor (will delete later)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accType = AccountType.USER;
        this.matureContentVisible = false;
        this.isBanned = false;
    }

    //Standard new account constructor
    public User(String username, String password, AccountType accType) {
        this.username = username;
        this.password = password;
        this.accType = accType;
        this.matureContentVisible = false;
        this.isBanned = false;
    }

    //All Args Constructor
    public User(int userId, String pfp, String username, String password, boolean matureContentVisible, boolean isBanned, AccountType accType) {
        this.userId = userId;
        this.pfp = pfp;
        this.username = username;
        this.password = password;
        this.matureContentVisible = matureContentVisible;
        this.isBanned = isBanned;
        this.accType = accType;
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

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }
}
