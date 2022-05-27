package com.example.springpractice.reservation;

import com.example.springpractice.Person;
import com.example.springpractice.accessory.Accessory;
import com.example.springpractice.customer.Customer;
import com.example.springpractice.motorhome.Motorhome;
import com.example.springpractice.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    //@OneToOne
    //@JoinColumn(name = "motorhomeTypeId", referencedColumnName = "id")
    //private MotorhomeType motorhomeType;

    @OneToOne
    @JoinColumn(name = "motorhomeId", referencedColumnName = "id")
    private Motorhome motorhome;

    @OneToMany
    @JoinColumn(name = "accessory_id", referencedColumnName = "id")
    private List<Accessory> accessory;

}

