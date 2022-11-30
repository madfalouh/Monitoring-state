package com.project.farmmanagement.service;

import com.project.farmmanagement.exception.AirHumidityNotFoundException;
import com.project.farmmanagement.exception.TemperatureNotFoundException;
import com.project.farmmanagement.model.AirHumidity;
import com.project.farmmanagement.model.Temperature;
import com.project.farmmanagement.repo.AirHumidityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirHumidityService {

    private final AirHumidityRepo airHumidityRepo;

    @Autowired
    public AirHumidityService(AirHumidityRepo airHumidityRepo) {
        this.airHumidityRepo = airHumidityRepo;
    }

    public AirHumidity addAirHumidity(AirHumidity airHumidity){
        return airHumidityRepo.save(airHumidity) ;
    }
    public List<AirHumidity> findAllAirHumidities(){
        return airHumidityRepo.findAll();
    }





    public AirHumidity updateAirHumidity(AirHumidity airHumidity){
        return airHumidityRepo.save(airHumidity);
    }


    public AirHumidity findAirHumidityById(Long id){
        return airHumidityRepo.findAirHumidityById(id).orElseThrow(()->new AirHumidityNotFoundException("AirHumidity by id "+id+" was not found"));
    }

    public void deleteAirHumidity(Long id){
        airHumidityRepo.deleteAirHumidityById(id);
    }
}
