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

    @GetMapping("/admin")
    String admin(){
        return "admin/index";
    }

    @GetMapping("admin/manageEmployee")
    String manageEmployee(){
        return "admin/manageEmployee";
    }

    @GetMapping("admin/manageMotorhomes")
    String manageMotorhomes(){
        return "admin/manageMotorhomes";
    }
}
