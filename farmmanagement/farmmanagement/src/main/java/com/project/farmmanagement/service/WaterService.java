package com.project.farmmanagement.service;

import com.project.farmmanagement.exception.TemperatureNotFoundException;
import com.project.farmmanagement.exception.WaterNotFoundException;
import com.project.farmmanagement.model.Temperature;
import com.project.farmmanagement.model.Water;
import com.project.farmmanagement.repo.WaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterService {
    private final WaterRepo waterRepo;

    @Autowired
    public WaterService(WaterRepo waterRepo) {
        this.waterRepo = waterRepo;
    }


    public Water addWater(Water water){
        return waterRepo.save(water) ;
    }
    public List<Water> findAllWaters(){
        return waterRepo.findAll();
    }





    public Water updateWater(Water water){
        return waterRepo.save(water);
    }


    public Water findWaterById(Long id){
        return waterRepo.findWaterById(id).orElseThrow(()->new WaterNotFoundException("Water by id "+id+" was not found"));
    }

    public void deleteWater(Long id){
        waterRepo.deleteWaterById(id);
    }
}
