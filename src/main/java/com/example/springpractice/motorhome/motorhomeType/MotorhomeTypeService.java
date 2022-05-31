/*
===============
Martin
===============
*/
package com.example.springpractice.motorhome.motorhomeType;

import com.example.springpractice.motorhome.motorhomeType.MotorhomeType;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeTypeService {

    ////dependency injection
    @Autowired
    private MotorhomeTypeRepo motorhomeTypeRepo;

    //Get all types of motorhomes from database
    public List<MotorhomeType> getAllTypes() {
        return motorhomeTypeRepo.findAll();
    }

    //public void saveMotorhomeType(MotorhomeType motorhomeType) {this.motorhomeTypeRepo.save(motorhomeType);}

    public List<MotorhomeType> getAllPrices() {
        return motorhomeTypeRepo.findAll();
    }
}
