package com.example.springpractice.motorhome;

import com.example.springpractice.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotorhomeController {

    @Autowired
    private MotorhomeService motorhomeService;

    //display list of employees
    @GetMapping("/viewMotorhomePage")
    public String viewMotorhomePage(Model model){
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        return "admin/motorhome/index";
    }

    //add new motorhome
    @GetMapping("/showNewMotorhomeForm")
    public String showNewMotorhomeForm(Model model) {
        Motorhome motorhome = new Motorhome();
        model.addAttribute("motorhome",motorhome);
        return "admin/motorhome/newMotorhome";
    }

    @PostMapping("/saveMotorhome")
    public String saveEmployee(@ModelAttribute("motorhome") Motorhome motorhome) {
        motorhomeService.saveMotorhome(motorhome);
        return "redirect:viewMotorhomePage";
    }
}
