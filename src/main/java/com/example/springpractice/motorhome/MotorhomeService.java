package com.example.springpractice.motorhome;

import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorhomeService {

    //dependency injection
    @Autowired
    private MotorhomeRepo motorhomeRepo;

    //Get all motorhomes from database
    public List<Motorhome> getAllMotorhomes() {
        return motorhomeRepo.findAll();
    }

    //saves motorhome to the database
    public void saveMotorhome(Motorhome motorhome) {
        this.motorhomeRepo.save(motorhome);
    }

    //gets specific motorhome with the selected ID
    public Motorhome getMotorhomeById(int id){
        Optional<Motorhome> optional = motorhomeRepo.findById(id);
        Motorhome motorhome = null;
        if(optional.isPresent()) {
            motorhome = optional.get();
        } else {
            throw new RuntimeException("Motorhome not found for id " + id);
        }
        return motorhome;
    }

    //deletes motorhome with selected ID
    public void deleteMotorhomeById(int id) {
        this.motorhomeRepo.deleteById(id);
    }

}
