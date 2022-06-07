/*
===============
Everybody
===============
*/
package com.example.springpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    // Return homepage
    @GetMapping("/")
    String getHomepage(){
        return "index";
    }
}
