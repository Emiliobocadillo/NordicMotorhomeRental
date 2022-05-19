package com.example.springpractice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private ManageEmployeeRepository employeeRepo;

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    /*
    public Employee addEmployee(Employee emp) {
        return employeeRepo.addEmployee(emp);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepo.findEmployeeById(id);
    }

    public Boolean deleteEmployee(int id) {
        return employeeRepo.deleteEmployee(id);
    }

    public Employee updateEmployee(int id, Employee emp) {
        return employeeRepo.updateEmployee(id, emp);
    }

     */

}
