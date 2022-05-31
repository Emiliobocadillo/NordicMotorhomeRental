/*
===============
Nayeem & Emil
===============
*/
package com.example.springpractice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String addUser(Model model, User user, String loginPage, String adminPage, String reservationPage){
        return userRepo.addUser(model,user, loginPage, adminPage, reservationPage);
    }

    public String checkUser(Model model, User user, String loginPage, String adminPage, String reservationPage) {
        return userRepo.checkUser(model, user, loginPage, adminPage, reservationPage);
    }

    public String getAdminName(String username, String password){
        return userRepo.getAdminName(username, password);
    }
}
