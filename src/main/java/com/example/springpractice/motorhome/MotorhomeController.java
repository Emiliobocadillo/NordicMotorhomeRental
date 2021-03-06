/*
===============
Martin
===============
*/
package com.example.springpractice.motorhome;

import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotorhomeController {

    //Dependency injection
    @Autowired
    private MotorhomeService motorhomeService;
    @Autowired
    private MotorhomeTypeService motorhomeTypeService;

    //Displays list of motorhomes
    @GetMapping("/viewMotorhomePage")
    public String viewMotorhomePage(Model model){
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        model.addAttribute("listOfTypes",motorhomeTypeService.getAllTypes());
        return "admin/motorhome/motorhomePage";
    }

    //Displays form for adding a new motorhome
    @GetMapping("/showNewMotorhomeForm")
    public String showNewMotorhomeForm(Model model) {
        Motorhome motorhome = new Motorhome();
        model.addAttribute("motorhome",motorhome);
        model.addAttribute("listOfTypes", motorhomeTypeService.getAllTypes());
        return "admin/motorhome/newMotorhome";
    }

    //submit the values from the forms AddNewMotorhome or UpdateMotorhome to the database
    @PostMapping("/saveMotorhome")
    public String saveMotorhome(@ModelAttribute("motorhome") Motorhome motorhome) {
        motorhomeService.saveMotorhome(motorhome);
        return "redirect:viewMotorhomePage";
    }

    //Displays form for updating motorhome with the selected ID
    @GetMapping("/showMotorhomeUpdateForm/{id}")
    public String showMotorhomeUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Motorhome motorhome = motorhomeService.getMotorhomeById(id);
        model.addAttribute("motorhome",motorhome);
        model.addAttribute("listOfTypes", motorhomeTypeService.getAllTypes());
        return "admin/motorhome/updateMotorhome";
    }

    //Deletes the motorhome with the selected ID
    @GetMapping("/deleteMotorhome/{id}")
    public String deleteMotorhome(@PathVariable(value = "id")int id) {
        this.motorhomeService.deleteMotorhomeById(id);
        return "redirect:/viewMotorhomePage";
    }

}
