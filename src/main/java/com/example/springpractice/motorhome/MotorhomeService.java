package com.example.springpractice.motorhome;

import com.example.springpractice.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeService {

    @Autowired
    private MotorhomeRepo motorhomeRepo;

    public List<Motorhome> getAllMotorhomes() {
        return motorhomeRepo.findAll();
    }

    public void saveMotorhome(Motorhome motorhome) {
        this.motorhomeRepo.save(motorhome);
    }
}
