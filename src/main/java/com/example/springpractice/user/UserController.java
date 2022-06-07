/*
===============
Emil & Nayeem
===============
*/
package com.example.springpractice.user;

import com.example.springpractice.employee.EmployeeService;
import com.example.springpractice.motorhome.MotorhomeService;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeService;
import com.example.springpractice.reservation.ReservationService;
import com.example.springpractice.user.User;
import com.example.springpractice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private MotorhomeService motorhomeService;

    @GetMapping("/login")
    String login(){
        return "/login";
    }


    @PostMapping("/checkUser")
    public String checkUser(@ModelAttribute User user, Model model){
        model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
        model.addAttribute("listOfReservations",reservationService.getAllReservations());
        model.addAttribute("motorhome",motorhomeService.getAllMotorhomes());
        return userService.checkUser(model, user, "redirect:/login","redirect:/admin", "redirect:/viewReservationPage" );
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@ModelAttribute User user, Model model){
        model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
        model.addAttribute("listOfReservations",reservationService.getAllReservations());
        model.addAttribute("motorhome",motorhomeService.getAllMotorhomes());
        return userService.addUser(model, user, "redirect:/login", "redirect:/admin", "redirect:/viewReservationPage");
    }


}
