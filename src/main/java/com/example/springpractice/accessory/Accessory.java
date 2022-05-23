package com.example.springpractice.accessory;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String name;
    private int totalStock;
    private int available;
    private int rentedOut;
    private double pricePerDay;
}
