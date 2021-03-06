/*
===============
Martin and Nayeem
===============
*/
package com.example.springpractice.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    //Dependency injection
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Gets all reservation from the database
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    //Unique email
    //Checks that the mail you're trying to enter don't exist before saving
    public String saveReservation(Reservation reservation, String reservationPage ,String newReservationPage) {
        int count = 0;
        String sql = "SELECT COUNT(email) FROM reservation WHERE email = ?";
        count = jdbcTemplate.queryForObject(sql, new Object[] {reservation.getEmail()}, Integer.class);
        if (count == 1){
            return newReservationPage;
        }
        else {
            this.reservationRepo.save(reservation);
            return reservationPage;
        }

    }

    public void updateReservation(Reservation reservation){
        reservationRepo.save(reservation);
    }

    //gets specific reservation with the selected ID
    public Reservation getReservationById(int id){
        Optional<Reservation> optional = reservationRepo.findById(id);
        Reservation reservation = null;
        if(optional.isPresent()) {
            reservation = optional.get();
        } else {
            throw new RuntimeException(" Booking not found for id" + id);
        }
        return reservation;
    }

    //Delete reservation with selected ID
    public void deleteReservationById(int id) {
        this.reservationRepo.deleteById(id);
    }
}
