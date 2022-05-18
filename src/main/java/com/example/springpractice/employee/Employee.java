package com.example.springpractice.employee;

import com.example.springpractice.Person;
import javax.persistence.*;

import com.example.springpractice.user.User;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {

    private String jobTitle;
    private boolean admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

}
