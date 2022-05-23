package com.example.springpractice.accessory;


import com.example.springpractice.motorhome.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessoryService {

    @Autowired
    private AccessoryRepo accessoryRepo;

    public List<Accessory> getAllAccessories(){return accessoryRepo.findAll();}


    public void saveAccessory(Accessory accessory) {this.accessoryRepo.save(accessory);}


    public Accessory getAccessoryById(int id){
        Optional<Accessory> optional = accessoryRepo.findById(id);
        Accessory accessory = null;
        if(optional.isPresent()){
            accessory = optional.get();
        } else {
            throw new RuntimeException("Accessory not found for id " + id);
        }
        return accessory;
    }


    public void deleteAccessoryById(int id){this.accessoryRepo.deleteById(id);}








}
