package com.example.springpractice.reservation;

import com.example.springpractice.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    //display list of employees
    @GetMapping("/viewReservationPage")
    public String viewReservationPage(Model model){
        model.addAttribute("listOfReservations", reservationService.getAllReservations());
        return "admin/reservation/index";
    }

    //add new employee
    @GetMapping("/showNewReservationForm")
    public String showNewReservationForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "admin/reservation/newReservation";
    }

    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:viewReservationPage";
    }

    @GetMapping("/showReservationUpdateForm/{id}")
    public String showReservationUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation",reservation);
        return "admin/reservation/updateReservation";
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable(value = "id")int id) {
        this.reservationService.deleteReservationById(id);
        return "redirect:/viewReservationPage";
    }

}
