package com.example.springpractice.motorhome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Motorhome getMotorhomeById(int id){
        Optional<Motorhome> optional = motorhomeRepo.findById(id);
        Motorhome motorhome = null;
        if(optional.isPresent()) {
            motorhome = optional.get();
        } else {
            throw new RuntimeException(" Motorhome not found for id" + id);
        }
        return motorhome;
    }

    public void deleteMotorhomeById(int id) {
        this.motorhomeRepo.deleteById(id);
    }
}
