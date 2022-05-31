/*
===============
Martin & Nayeem
===============
*/
package com.example.springpractice.employee;

import com.example.springpractice.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    //dependency injection to use EmployeeRepo class
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    JdbcTemplate jdbcTemplate;
/*
    private checkEmail(){
        employeeRepo.
    }

 */

    //get a list of all employees from database
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    //Save an employee to the database
    public String saveEmployee(Employee employee, String employeePage , String newEmployeePage) {
        int count = 0;
        String sql = "SELECT COUNT(email) FROM employee WHERE email = ?";
        count = jdbcTemplate.queryForObject(sql, new Object[] {employee.getEmail()}, Integer.class);
        if (count == 1){
            return newEmployeePage;
        }
        else {
            this.employeeRepo.save(employee);
            return employeePage;
        }

    }

    public void updateEmployee(Employee employee, String employeePage , String newEmployeePage){
//        String email = "";
//        String sql = "SELECT email FROM employee WHERE email = ?";
//        email = jdbcTemplate.queryForObject(sql, new Object[] {employee.getEmail()}, String.class);
//        System.out.println(email);
//        if (email.equals(employee.getEmail())){
//            return newEmployeePage;
//        }
//        else {
//            this.employeeRepo.save(employee);
//            return employeePage;
//        }
        this.employeeRepo.save(employee);
    }







    //get employee with specific ID from database
    public Employee getEmployeeById(int id){
        Optional<Employee> optional = employeeRepo.findById(id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id" + id);
        }
        return employee;
    }


    //Delete an employee from database
    public void deleteEmployeeById(int id) {
        this.employeeRepo.deleteById(id);
    }



}
