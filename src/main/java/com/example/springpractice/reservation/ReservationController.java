package com.example.springpractice.reservation;

import com.example.springpractice.motorhome.MotorhomeService;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private MotorhomeTypeService motorhomeTypeService;

    @Autowired
    private MotorhomeService motorhomeService;


    //display list of employees
    @GetMapping("/viewReservationPage")
    public String viewReservationPage(Model model){
        model.addAttribute("listOfReservations",reservationService.getAllReservations());
        model.addAttribute("motorhome",motorhomeService.getAllMotorhomes());
        return "reservation/reservationPage";
    }

    //add new employee
    @GetMapping("/showNewReservationForm")
    public String showNewReservationForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        return "reservation/newReservation";
    }

    @GetMapping("/selectMotorhome")
    public String showAvailableMotorhomes(Model model) {
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        return "reservation/selectMotorhome";
    }

    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation, Model model) {
        model.addAttribute("listOfReservations",reservationService.getAllReservations());
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        //        reservationService.saveReservation(reservation);
        return reservationService.saveReservation(reservation, "redirect:/viewReservationPage", "reservation/newReservation");
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("reservation") Reservation reservation) {
        return reservationService.saveReservation(reservation, "reservation/reservationPage", "reservation/newReservation");
//        reservationService.saveReservation(reservation);
//        return "redirect:selectMotorhome";
    }

    @GetMapping("/showReservationUpdateForm/{id}")
    public String showReservationUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation",reservation);
        model.addAttribute("listOfMotorhomes", motorhomeService.getAllMotorhomes());
        return "reservation/updateReservation";
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable(value = "id")int id) {
        this.reservationService.deleteReservationById(id);
        return "redirect:/viewReservationPage";
    }

}
