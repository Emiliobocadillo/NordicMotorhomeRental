package com.example.springpractice.Repository;

import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class EmployeeRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Employee> fetchAll() {
        String sql = "select id, fulName, phoneNr, username, jobTitle  from employees";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public Employee addEmployee(Employee emp) {
        String sql = "insert into employees (firstname, lastname, dateOfBirth, address, city, phoneNr, username, jobTitle, credentials) Values (?,?,?)";
        template.update(sql, emp.getFullName(),emp.getDateOfBirth(),emp.getAddress(),emp.getCity(), emp.getPhoneNr(), emp.getUsername(), emp.getJobTitle(), emp.getCredentials());
        return null;
    }

    //find and show user information via user's id
    public Employee findEmployeeById(int id) {
        String sql = "select FullName, username, favTeacher from users where usrID = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee emp = template.queryForObject(sql, rowMapper, id);
        return emp;
    }

    //delete a user via user id
    public Boolean deleteEmployee(int id) {
        String sql = "delete from Employee where id = ?";
        return template.update(sql, id) > 0;
    }

    //find and edit a user's information via user's id
    public Employee updateEmployee(int id, Employee emp) {
        String sql = "update users set usrName = ?, favTeacher = ? where usrID = ?";
        template.update(sql, emp.getFullName(), emp.getDateOfBirth(), emp.getAddress(), emp.getCity(), emp.getPhoneNr(), emp.getUsername(), emp.getJobTitle(), emp.getCredentials());
        return null;
    }

}
