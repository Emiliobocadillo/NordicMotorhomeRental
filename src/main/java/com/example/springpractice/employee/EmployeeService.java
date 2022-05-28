package com.example.springpractice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    //dependency injection to use EmployeeRepo class
    @Autowired
    private EmployeeRepo employeeRepo;
/*
    private checkEmail(){
        employeeRepo.
    }

 */

    //get a list of all employees from database
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    //Save an employee to the satabase
    public void saveEmployee(Employee employee) {
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
