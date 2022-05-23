package com.example.springpractice;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Data
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",
    updatable = false)
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;

    @Column(unique = true)
    private String email;
    private String address;
    private String city;
    @Column(name="phoneNr")
    private String phoneNr;

}
