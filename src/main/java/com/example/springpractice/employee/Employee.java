/*
===============
Martin
===============
*/
package com.example.springpractice.employee;

import com.example.springpractice.Person;
import javax.persistence.*;

import com.example.springpractice.user.User;
import lombok.*;

@Entity
@Data
public class Employee extends Person {

    private String jobTitle;
    private boolean admin;

    @Override
    public String toString() {
        return "Employee{" +
                "jobTitle='" + jobTitle + '\'' +
                ", admin=" + admin +
                '}';
    }
}
