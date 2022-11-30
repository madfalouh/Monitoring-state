package com.project.farmmanagement;


import com.project.farmmanagement.model.SoilMoisture;
import com.project.farmmanagement.service.SoilMoistureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soilMoisture")
public class SoilMoistureResource {
    private final SoilMoistureService soilMoistureService;

    public SoilMoistureResource(SoilMoistureService soilMoistureService) {
        this.soilMoistureService = soilMoistureService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SoilMoisture>> getAllSoilMoistures(){
        List<SoilMoisture> soilMoistures= soilMoistureService.findAllSoilMoistures();
        return new ResponseEntity<>(soilMoistures, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SoilMoisture> getSoilMoistureById(@PathVariable("id") Long id){
        SoilMoisture soilMoisture= soilMoistureService.findSoilMoistureById(id);
        return new ResponseEntity<>(soilMoisture, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<SoilMoisture> addSoilMoisture(@RequestBody SoilMoisture soilMoisture){
        SoilMoisture newSoilMoisture= soilMoistureService.addSoilMoisture(soilMoisture);
        return new ResponseEntity<>(newSoilMoisture, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<SoilMoisture> updateSoilMoisture(@RequestBody SoilMoisture soilMoisture){
        SoilMoisture updateSoilMoisture=soilMoistureService.updateSoilMoisture(soilMoisture);
        return new ResponseEntity<>(soilMoisture, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteSoilMoisture(@PathVariable("id") Long id){
        soilMoistureService.deleteSoilMoisture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
