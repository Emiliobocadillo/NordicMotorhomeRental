package com.example.springpractice.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageEmployeeRepository extends JpaRepository<Employee, Integer> {


}
