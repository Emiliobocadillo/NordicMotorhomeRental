package com.example.springpractice.motorhome.motorhomeType;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MotorhomeType {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String type;

}
