package com.example.springpractice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User addNewUser(User user){
       userRepo.addNewUser(user);
       return null;
    }

}
