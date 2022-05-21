package com.example.springpractice.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    //dependency injection to use UserRepo class
    @Autowired
    private EmployeeRepo employeeRepo;

    /*
    public List<Employee> fetchAllEmployees() {
        return employeeRepo.fetchAllEmployees();
    }

     */


    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);
    }

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
    /*
    public Employee addEmployee(Employee employee) {
        return employeeRepo.addEmployee(employee);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepo.findEmployeeById(id);
    }

    public Boolean deleteEmployee(int id) {
        return employeeRepo.deleteEmployee(id);
    }

    public Employee updateEmployee(int id, Employee employee) {
        return employeeRepo.updateEmployee(id, employee);
    }

     */


}
