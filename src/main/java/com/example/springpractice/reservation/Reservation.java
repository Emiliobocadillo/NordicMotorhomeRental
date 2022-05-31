/*
===============
Martin
===============
*/
package com.example.springpractice.reservation;

import com.example.springpractice.Person;
import com.example.springpractice.accessory.Accessory;
import com.example.springpractice.motorhome.Motorhome;

import lombok.Data;


import javax.persistence.*;

import java.util.List;

@Entity
@Data
public class Reservation extends Person {

    @Column(name = "AoP")
    private int amountOfPeople;

    String startDate;
    String endDate;

    @OneToOne
    @JoinColumn(name = "motorhomeId", referencedColumnName = "id")
    private Motorhome motorhome;

    @ManyToMany
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private List<Accessory> accessory;

}

