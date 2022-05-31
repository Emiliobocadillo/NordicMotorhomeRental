/*
===============
Martin
===============
*/
package com.example.springpractice;

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
    @Column(name = "firstname",nullable = false)
    private String firstName;
    @Column(name="lastname", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(name="phoneNr",nullable = false)
    private String phoneNr;

}
