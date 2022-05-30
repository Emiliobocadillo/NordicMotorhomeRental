package com.example.springpractice.motorhome;

import com.example.springpractice.motorhome.motorhomeType.MotorhomeType;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Motorhome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private MotorhomeType motorhomeType;
    private String brand;
    private String model;
    private int beds;
    private double price;

}
