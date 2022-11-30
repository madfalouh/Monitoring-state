package com.project.farmmanagement.service;

import com.project.farmmanagement.exception.SoilMoistureNotFoundException;
import com.project.farmmanagement.exception.TemperatureNotFoundException;
import com.project.farmmanagement.model.SoilMoisture;
import com.project.farmmanagement.model.Temperature;
import com.project.farmmanagement.repo.SoilMoistureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilMoistureService {
    private final SoilMoistureRepo soilMoistureRepo;

    @Autowired
    public SoilMoistureService(SoilMoistureRepo soilMoistureRepo) {
        this.soilMoistureRepo = soilMoistureRepo;
    }

    public SoilMoisture addSoilMoisture(SoilMoisture soilMoisture){
        return soilMoistureRepo.save(soilMoisture) ;
    }
    public List<SoilMoisture> findAllSoilMoistures(){
        return soilMoistureRepo.findAll();
    }





    public SoilMoisture updateSoilMoisture(SoilMoisture soilMoisture){
        return soilMoistureRepo.save(soilMoisture);
    }


    public SoilMoisture findSoilMoistureById(Long id){
        return soilMoistureRepo.findSoilMoistureById(id).orElseThrow(()->new SoilMoistureNotFoundException("SoilMoisture by id "+id+" was not found"));
    }

    public void deleteSoilMoisture(Long id){
        soilMoistureRepo.deleteSoilMoistureById(id);
    }
}
