package com.example.springpractice.Controller;

import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import services.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //get the mapping for index page
    @GetMapping("/employee")
    //create a list of users @fetchAll() - add them to the model
    public String index(Model model) {
        List<Employee> employeeList = employeeService.fetchAll();
        model.addAttribute("employees", employeeList);
        return "/employee";
    }

    //get the mapping for addUser page
    @GetMapping("/addUser")
    public String add() {
        return "home/addUser";
    }

    //from addUser page - posts the new employee into the model(table)
    //redirects to index page
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    //get the mapping for viewUser page
    //returns user via id
    @GetMapping("/viewUser")
    public String viewUser(@PathVariable() int id, Model model) {
        model.addAttribute("user", employeeService.findEmployeeById(id));
        return "home/viewUser";
    }

    //deletes user via id
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        boolean deleted = employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    //get the mapping for editUser page
    //returns user via id
    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", employeeService.findEmployeeById(id));
        return "home/editUser";
    }

    //from editUser page - posts the edited employee into the model(table)
    //redirects to index page
    @PostMapping("/edit")
    public String edit(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee.getId(), employee);
        return "redirect:/";
    }


}
