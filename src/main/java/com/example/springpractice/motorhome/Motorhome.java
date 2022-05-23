package com.example.springpractice.motorhome;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Motorhome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String name;
    private String type;
    private String make;
    private String model;
    private int beds;
    private double price;
    private boolean available;

}
