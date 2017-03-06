package Model;

import Enum.Gender;

public class User {
    private int id;
    
    private String name;
    
    private String surName;
    
    private String password;
    
    private Gender gender;

    public User(String name, String password, String surname, Gender gender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public User() {
    }

    public User(int id, String name, String surName, String password, Gender gender) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.gender = gender;
    }
    
    
}
