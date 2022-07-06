package com.example.electricitybill.controller;

import com.example.electricitybill.entity.Customer;
import com.example.electricitybill.entity.Reading;
import com.example.electricitybill.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private ReadingService service;
    @PostMapping("/addReading/{id}")
    public Customer addReading(@PathVariable (value = "id")int id , @RequestBody Reading reading){
        return service.saveReading(id ,reading);
    }
    @GetMapping("/Readings")
    public List<Reading>findAllReadings(){
        return service.getReadings();
    }
    @GetMapping("/ReadingById/{id}")
    public Reading  findAllReadingById(@PathVariable int id){
        return service.getReadingById(id);
    }
    @GetMapping("/delete1/{id}")
    public String deleteReading(@PathVariable int id){
        return service.deleteReading(id);
    }



}
