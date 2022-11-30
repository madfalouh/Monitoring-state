package com.project.farmmanagement.service;

import com.project.farmmanagement.exception.TemperatureNotFoundException;
import com.project.farmmanagement.model.Temperature;
import com.project.farmmanagement.repo.TemperatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {
    private final TemperatureRepo temperatureRepo;

    @Autowired
    public TemperatureService(TemperatureRepo temperatureRepo) {
        this.temperatureRepo = temperatureRepo;
    }



    public Temperature addTemperature(Temperature temperature){
        return temperatureRepo.save(temperature) ;
    }
    public List<Temperature> findAllTemperatures(){
        return temperatureRepo.findAll();
    }





    public Temperature updateTemperature(Temperature temperature){
        return temperatureRepo.save(temperature);
    }


    public Temperature findTemperatureById(Long id){
        return temperatureRepo.findTemperatureById(id).orElseThrow(()->new TemperatureNotFoundException("Temperature by id "+id+" was not found"));
    }

    public void deleteTemperature(Long id){
        temperatureRepo.deleteTemperatureById(id);
    }













}
