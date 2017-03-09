package Model;

import Enum.Gender;
import java.util.Objects;

public class User {

    private int id;

    private String name;

    private String surName;

    private String username;

    private String password;

    private Gender gender;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
    

    public User(int id, String name, String surName, String username, String password, Gender gender) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public User(String name, String surName, String username, String password, Gender gender) {
        this.name = name;
        this.surName = surName;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPassword() {
        return password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public String toString() {
        return name + " " + surName + " " + username + " " + gender;
    }


    

}
