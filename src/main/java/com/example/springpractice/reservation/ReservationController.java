/*
===============
Martin
===============
*/
package com.example.springpractice.reservation;

import com.example.springpractice.motorhome.MotorhomeService;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    //Dependency injection
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private MotorhomeService motorhomeService;


    //Displays a list of reservations
    @GetMapping("/viewReservationPage")
    public String viewReservationPage(Model model){
        model.addAttribute("listOfReservations",reservationService.getAllReservations());
        model.addAttribute("motorhome",motorhomeService.getAllMotorhomes());
        return "reservation/reservationPage";
    }

    //Displays form for adding a new Reservation
    @GetMapping("/showNewReservationForm")
    public String showNewReservationForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        return "reservation/newReservation";
    }

    //submit the values from the forms AddNewReservation or UpdateReservation to the database
    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation, Model model) {
        return reservationService.saveReservation(reservation, "redirect:/viewReservationPage", "reservation/newReservation");
    }

    @PostMapping("/updateReservation")
    public String updateReservation(@ModelAttribute("reservation") Reservation reservation, Model model) {
        reservationService.updateReservation(reservation);
        return "redirect:/viewReservationPage";
    }

    //Displays form for updating reservation by selected ID
    @GetMapping("/showReservationUpdateForm/{id}")
    public String showReservationUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation",reservation);
        model.addAttribute("listOfMotorhomes", motorhomeService.getAllMotorhomes());
        return "reservation/updateReservation";
    }

    //Delete reservation with selected ID
    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable(value = "id")int id) {
        this.reservationService.deleteReservationById(id);
        return "redirect:/viewReservationPage";
    }

}
