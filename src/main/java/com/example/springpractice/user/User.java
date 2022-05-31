/*
===============
Martin & Nayeem
===============
*/
package com.example.springpractice.user;
import com.example.springpractice.employee.Employee;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    private String email;

    @Column(unique = true,
    nullable = false)
    private String username;

    @Column(nullable = false)
    private  String password;

}
