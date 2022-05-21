package com.example.springpractice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate template;

        //retrieve the user id - user name - & favorite teacher from "users" table
        public List<Employee> fetchAllEmployees() {
            String sql = "select id, firstname, lastname, dob, phone_nr, email, address, city, job_title, admin, user_id from employee";
            RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
            return template.query(sql, rowMapper);
        }

        //add a new employee with id(auto-increments) - employee name - password - & favorite teacher
        public Employee addEmployee(Employee employee) {
            String sql = "insert into employee (first_name, last_name, phone_nr, email, address, city, job_title,admin) values (?, ?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, employee.getFirstName(), employee.getLastName(), employee.getPhoneNr(),employee.getEmail(),employee.getAddress(),employee.getCity(),employee.getJobTitle(),employee.isAdmin());
            return null;
        }

        //find and show user information via user's id
        public Employee findEmployeeById(int id) {
            String sql = "select first_name, last_name, phone_nr, email, address, city, job_title,admin from employee where id = ?";
            RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
            Employee employee = template.queryForObject(sql, rowMapper, id);
            return employee;
        }

        //delete a user via user id
        public Boolean deleteEmployee(int id) {
            String sql = "delete from employee where id = ?";
            return template.update(sql, id) > 0;
        }

        //find and edit an employee's information via employee's id
        public Employee updateEmployee(int id, Employee employee) {
            String sql = "update employee set first_name = ?, last_name = ?, phone_nr = ?, email = ?, address = ?, city = ?, job_title = ?, admin = ? where id = ?";
            template.update(sql, employee.getFirstName(), employee.getLastName(), employee.getPhoneNr(),employee.getEmail(),employee.getAddress(),employee.getCity(),employee.getJobTitle(),employee.isAdmin());
            return null;
        }



}
