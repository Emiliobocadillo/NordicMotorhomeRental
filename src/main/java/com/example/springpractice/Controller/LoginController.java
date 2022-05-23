package com.example.springpractice.Controller;

import com.example.springpractice.user.User;
import com.example.springpractice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    String login(){
        return "/login";
    }


    @PostMapping("/checkUser")
    public String checkUser(@ModelAttribute User user){
        return userService.checkUser(user,"/login","admin/admin", "/showNewEmployeeForm" );
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@ModelAttribute User user){
        return userService.addUser(user, "login", "admin/admin", "admin/employee/employeePage");
    }

}
