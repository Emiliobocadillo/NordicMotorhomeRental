package com.example.springpractice.motorhome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotorhomeController {

    @Autowired
    private MotorhomeService motorhomeService;

    //display list of motorhomes
    @GetMapping("/viewMotorhomePage")
    public String viewMotorhomePage(Model model){
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        return "admin/motorhome/motorhomePage";
    }

    //add new motorhome
    @GetMapping("/showNewMotorhomeForm")
    public String showNewMotorhomeForm(Model model) {
        Motorhome motorhome = new Motorhome();
        model.addAttribute("motorhome",motorhome);
        return "admin/motorhome/newMotorhome";
    }

    @PostMapping("/saveMotorhome")
    public String saveMotorhome(@ModelAttribute("motorhome") Motorhome motorhome) {
        motorhomeService.saveMotorhome(motorhome);
        return "redirect:viewMotorhomePage";
    }

    @GetMapping("/showMotorhomeUpdateForm/{id}")
    public String showMotorhomeUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Motorhome motorhome = motorhomeService.getMotorhomeById(id);
        model.addAttribute("motorhome",motorhome);
        return "admin/motorhome/updateMotorhome";
    }

    @GetMapping("/deleteMotorhome/{id}")
    public String deleteMotorhome(@PathVariable(value = "id")int id) {
        this.motorhomeService.deleteMotorhomeById(id);
        return "redirect:/viewMotorhomePage";
    }

}
