package com.project.farmmanagement;


import com.project.farmmanagement.model.Water;
import com.project.farmmanagement.service.WaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/water")
public class WaterResource {
    private final WaterService waterService;

    public WaterResource(WaterService waterService) {
        this.waterService = waterService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Water>> getAllWaters(){
        List<Water> waters= waterService.findAllWaters();
        return new ResponseEntity<>(waters, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Water> getWaterById(@PathVariable("id") Long id){
        Water water= waterService.findWaterById(id);
        return new ResponseEntity<>(water, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Water> addWater(@RequestBody Water water){
        Water newWater= waterService.addWater(water);
        return new ResponseEntity<>(newWater, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Water> updateWater(@RequestBody Water water){
        Water updateWater=waterService.updateWater(water);
        return new ResponseEntity<>(water, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteWater(@PathVariable("id") Long id){
        waterService.deleteWater(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
