package com.example.springpractice.Repository;

import com.example.springpractice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public User addNewUser(User user){
        String sql = "INSERT INTO users (name, username, password) VALUES (?,?,?);";
        jdbcTemplate.update(sql, user.getName(), user.getUsername(), user.getPassword());
        return null;
    }
}
