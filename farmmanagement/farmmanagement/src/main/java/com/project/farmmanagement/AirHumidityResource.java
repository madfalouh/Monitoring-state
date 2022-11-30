package com.project.farmmanagement;


import com.project.farmmanagement.model.AirHumidity;
import com.project.farmmanagement.model.Temperature;
import com.project.farmmanagement.service.AirHumidityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airHumidity")
public class AirHumidityResource {
    private final AirHumidityService airHumidityService;

    public AirHumidityResource(AirHumidityService airHumidityService) {
        this.airHumidityService = airHumidityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AirHumidity>> getAllAirHumidities(){
        List<AirHumidity> airHumidities= airHumidityService.findAllAirHumidities();
        return new ResponseEntity<>(airHumidities, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AirHumidity> getAirHumidityById(@PathVariable("id") Long id){
        AirHumidity airHumidity= airHumidityService.findAirHumidityById(id);
        return new ResponseEntity<>(airHumidity, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<AirHumidity> addAirHumidity(@RequestBody AirHumidity airHumidity){
        AirHumidity newAirHumidity= airHumidityService.addAirHumidity(airHumidity);
        return new ResponseEntity<>(newAirHumidity, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<AirHumidity> updateAirHumidity(@RequestBody AirHumidity airHumidity){
        AirHumidity updateAirHumidity=airHumidityService.updateAirHumidity(airHumidity);
        return new ResponseEntity<>(updateAirHumidity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteAirHumidity(@PathVariable("id") Long id){
        airHumidityService.deleteAirHumidity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
