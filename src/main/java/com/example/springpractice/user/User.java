package com.example.springpractice.user;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    //change so it gets name from employee
    private String name;

    @Column(unique = true,
    nullable = false)
    private String username;

    @Column(nullable = false)
    private  String password;

    /*
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
    to be deleted if lombok works like expected
     */
}
