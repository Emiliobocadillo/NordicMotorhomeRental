package com.example.springpractice.user;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
    @Id
    private String name;
    private String username;
    private  String password;

    //Constructor
    public User(){}

    //Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getters

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
