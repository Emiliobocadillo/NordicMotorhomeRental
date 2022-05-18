package com.example.springpractice.employee;

import com.example.springpractice.user.User;
import com.example.springpractice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/booking")
    String registration(){
        return "admin";
    }

    @PostMapping("/adminPage")
    public String getEmployee(@ModelAttribute Employee employee){
        employeeService.getEmployees(employee);
        return "/admin";

    }
}
