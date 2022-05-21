package com.example.springpractice.employee;

import com.example.springpractice.Person;
import javax.persistence.*;

import com.example.springpractice.user.User;
import lombok.*;

@Entity
@Data
public class Employee extends Person {

    @Column(name = "jobTitle")
    private String jobTitle;
    private boolean admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return "Employee{" +
                "jobTitle='" + jobTitle + '\'' +
                ", admin=" + admin +
                ", user=" + user +
                '}';
    }
}
