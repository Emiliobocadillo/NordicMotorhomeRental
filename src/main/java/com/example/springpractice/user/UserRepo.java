package com.example.springpractice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
    String sql = "INSERT into user (username,password,Employee_id,admin) " +
            "SELECT '?','?' , Employee.id , employee.admin from employee WHERE employee.email ='Martin.nh.1993@gmail.com'";
     */

    public String addUser(User user, String loginPage, String adminPage, String employeePage){
        int count = 0;
        String sql = "SELECT COUNT(username) FROM user WHERE username = ?";
        count = jdbcTemplate.queryForObject(sql, new Object[] {user.getUsername()}, Integer.class);
        if (count >= 1){
            System.out.println("User Exist");
            return loginPage;

        }else {
            String sql2 = "INSERT INTO user (name,username, password) VALUES (?,?,?);";
            if (user.getUsername().endsWith("ad")){
                jdbcTemplate.update(sql2, user.getName(), user.getUsername(), user.getPassword());
                return adminPage;
            }else  {
                jdbcTemplate.update(sql2, user.getName(), user.getUsername(), user.getPassword());
                return employeePage;
            }
        }
    }


    public String checkUser(User user, String loginPage, String adminPage, String employeePage){
        int count = 0;
        String sql = "SELECT COUNT(username) FROM user WHERE username = ? AND password = ?";
        count = jdbcTemplate.queryForObject(sql, new Object[] {user.getUsername(), user.getPassword()}, Integer.class);
        if (count == 1){
            if (user.getUsername().endsWith("ad")){
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
}
