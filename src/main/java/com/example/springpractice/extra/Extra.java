package com.example.springpractice.extra;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Extra {

    @Id
    private int id;
    private String item;
    private double price;

}
