package com.project.farmmanagement;

import com.project.farmmanagement.model.Temperature;
import com.project.farmmanagement.service.TemperatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/temperature")
public class TemperatureResource {
    private final TemperatureService temperatureService;

    public TemperatureResource(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Temperature>> getAllTemperatures(){
        List<Temperature> temperatures= temperatureService.findAllTemperatures();
        return new ResponseEntity<>(temperatures, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Temperature> getTemperatureById(@PathVariable("id") Long id){
        Temperature temperature= temperatureService.findTemperatureById(id);
        return new ResponseEntity<>(temperature, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Temperature> addTemperature(@RequestBody Temperature temperature){
        Temperature newTemperature= temperatureService.addTemperature(temperature);
        return new ResponseEntity<>(newTemperature, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Temperature> updateTemperature(@RequestBody Temperature temperature){
        Temperature updateTemperature=temperatureService.updateTemperature(temperature);
        return new ResponseEntity<>(temperature, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteTemperature(@PathVariable("id") Long id){
        temperatureService.deleteTemperature(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/barChart")
    public String getAllTemp(ModelAndView m) {

        List<String> valueList=temperatureService.findAllTemperatures().stream().map(x->x.getValue()).collect(Collectors.toList());
        List<String> dateList= temperatureService.findAllTemperatures().stream().map(x-> x.getDateAndTime()).collect(Collectors.toList());
        m.addObject("value", valueList);
        m.addObject("date", dateList);



        return "barChart";

    }
}
