package com.example.springpractice.motorhome.motorhomeType;

import com.example.springpractice.motorhome.motorhomeType.MotorhomeType;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeTypeService {

    @Autowired
    private MotorhomeTypeRepo motorhomeTypeRepo;

    public List<MotorhomeType> getAllTypes() {
        return motorhomeTypeRepo.findAll();
    }

    public void saveMotorhomeType(MotorhomeType motorhomeType) {
        this.motorhomeTypeRepo.save(motorhomeType);
    }

}
