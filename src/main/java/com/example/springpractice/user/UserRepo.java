package com.example.springpractice.user;

import com.example.springpractice.Controller.LoginController;
import com.example.springpractice.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    ArrayList<User> loggedInAdmin = new ArrayList<>();

    // Add a new user
    public String addUser(Model model, User user, String loginPage, String adminPage, String employeePage){
        loggedInAdmin.clear();
        int count = 0;
        String sql = "SELECT COUNT(username) FROM user WHERE username = ?";
        count = jdbcTemplate.queryForObject(sql, new Object[] {user.getUsername()}, Integer.class);
        if (count >= 1){
            System.out.println("User Exist");
            return loginPage;

        }else {
            int countForAdmin = 0;
            String sql2 = "SELECT e.admin FROM employee as e WHERE email = ?;";
            String sql3 = "INSERT INTO user (email,username, password) VALUES (?,?,?);";
            boolean admin = jdbcTemplate.queryForObject(sql2, new Object[] {user.getEmail()}, Boolean.class);

            if (admin == true){
                jdbcTemplate.update(sql3, user.getEmail(), user.getUsername(), user.getPassword());
                loggedInAdmin.add(user);
                model.addAttribute("admin",getAdminName(user.getUsername(),user.getPassword()));
                return adminPage;
            }else  {
                jdbcTemplate.update(sql3, user.getEmail(), user.getUsername(), user.getPassword());
                return employeePage;
            }
        }
    }

    // Check whether the user credential correct or  not.
    public String checkUser(Model model, User user, String loginPage, String adminPage, String employeePage){
        loggedInAdmin.clear();
        int count = 0;
        String sql = "SELECT COUNT(username) FROM user WHERE username = ? AND password = ?";
        count = jdbcTemplate.queryForObject(sql, new Object[] {user.getUsername(), user.getPassword()}, Integer.class);

        if (count == 1){

            String retrievedEmail = getEmployeeEmail(user.getUsername(), user.getPassword());
            String sql2 = "SELECT e.admin FROM employee as e WHERE email = ?;";
            boolean admin = jdbcTemplate.queryForObject(sql2, new Object[] {retrievedEmail}, Boolean.class);
            System.out.println(admin);

            if (admin==true){
                loggedInAdmin.add(user);
                model.addAttribute("admin",getAdminName(user.getUsername(),user.getPassword()));
                return adminPage;
            }
            else {
                return employeePage;
            }

        }else {
            System.out.println("User not exist");
            return loginPage;
        }

    }

    //Get employee email to check the ADMIN
    public String getEmployeeEmail(String username, String password) {
        List<User> employees = jdbcTemplate.query(
                "SELECT email FROM user WHERE username = ? AND password = ?;",
                new BeanPropertyRowMapper<>(User.class), username, password );
        return employees.get(0).getEmail();
    }

    // Getting the admin name for admin page
    public String getAdminName(String username, String password) {
        List<Employee> employees = jdbcTemplate.query(
                "SELECT firstname, lastname FROM employee AS e, user AS u WHERE e.email = (SELECT email FROM user WHERE username = ? AND password = ?);",
                new BeanPropertyRowMapper<>(Employee.class), username, password );
        return employees.get(0).getFirstName() + " " + employees.get(0).getLastName();
    }

    public String getAdminUser(){
        return loggedInAdmin.get(0).getUsername();
    }
    public String getAdminPassword(){
        return loggedInAdmin.get(0).getPassword();
    }

}




