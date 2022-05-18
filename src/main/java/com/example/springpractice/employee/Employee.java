package com.example.springpractice.employee;

import com.example.springpractice.Person;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee extends Person {

    private String username;
    private String password;
    private String jobTitle;
    private String credentials;

}
