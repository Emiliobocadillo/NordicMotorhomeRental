package com.example.springpractice.Service;

import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorys.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public List<Employee> fetchAll() {
        return employeeRepo.fetchAll();
    }

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

}
