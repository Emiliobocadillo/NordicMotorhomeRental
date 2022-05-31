package com.example.springpractice.accessory;

import lombok.*;
import javax.persistence.*;


@Entity
@Data
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int available;
    private int rented_out;
    private int total_stock;


    @Override
    public String toString() {
        return "Accessory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerDay=" + price +
                ", available=" + available +
                ", rentedOut=" + rented_out +
                ", totalStock=" + total_stock +
                '}';
    }
}
