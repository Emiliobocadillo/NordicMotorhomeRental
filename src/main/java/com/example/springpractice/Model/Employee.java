package com.example.springpractice.Model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee extends models.Person {

    private String username;
    private String password;
    private String jobTitle;
    private String credentials;

}
