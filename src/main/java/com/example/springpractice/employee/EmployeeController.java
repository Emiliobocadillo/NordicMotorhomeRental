package com.example.springpractice.employee;


import com.example.springpractice.user.User;
import com.example.springpractice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/admin")
    String admin(){
        return "admin";
    }

}

/*
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    //dependency injection to use UserService class
    @Autowired
    private EmployeeService employeeService;

    //get the mapping for index page
    @GetMapping("/")
    //create a list of users @fetchAll() - add them to the model
    public String index(Model model) {
        List<Employee> userList = employeeService.fetchAll();
        model.addAttribute("users", userList);
        return "home/index";
    }

    //get the mapping for addUser page
    @GetMapping("/employee")
    public String add() {
        return "home/employee";
    }

    //from addUser page - posts the new user into the model(table)
    //redirects to index page
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }


    //get the mapping for viewUser page
    //returns user via id
    @GetMapping("/viewUser/{id}")
    public String viewUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "home/viewUser";
    }

    //deletes user via id
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        boolean deleted = userService.deleteUser(id);
        return "redirect:/";
    }

    //get the mapping for editUser page
    //returns user via id
    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "home/editUser";
    }

    //from editUser page - posts the edited user into the model(table)
    //redirects to index page
    @PostMapping("/edit")
    public String edit(@ModelAttribute User user) {
        userService.updateUser(user.getUsrID(), user);
        return "redirect:/";
    }

     */

