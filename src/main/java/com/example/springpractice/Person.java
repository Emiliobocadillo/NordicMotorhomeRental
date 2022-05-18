package com.example.springpractice;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String city;
    private String address;
    private String phoneNr;

    /*
    //Getters
    public int getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmail() {return email;}
    public Date getDateOfBirth() {return dateOfBirth;}
    public String getCity() {return city;}
    public String getAddress() {return address;}
    public String getPhoneNr() {return phoneNr;}

    //No argument constructor
    public Person() {
    }

    //without ID constructor
    public Person(String firstName, String lastName, String email, Date dateOfBirth, String city, String address, String phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.address = address;
        this.phoneNr = phoneNr;
    }

    //All argument constructor
    public Person(int id, String firstName, String lastName, String email, Date dateOfBirth, String city, String address, String phoneNr) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.address = address;
        this.phoneNr = phoneNr;
    }

    //setters
    public void setId(int id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setCity(String city) {this.city = city;}
    public void setAddress(String address) {this.address = address;}
    public void setPhoneNr(String phoneNr) {this.phoneNr = phoneNr;}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                '}';
    }
    to be deleted if lombok getter, setter and so on works
     */
}
