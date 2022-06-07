/*
===============
Emil through IntelliJ
===============
*/
package com.example.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringPracticeApplication {



    // Thymeleaf looks for a html file called "index". If the file is found it is shown on the defined port number
    // By default Spring takes index template as the welcome page
    // If there is no file called index, a controller is needed to show a page
    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeApplication.class, args);
    }


}
