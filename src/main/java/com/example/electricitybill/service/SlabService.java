package com.example.electricitybill.service;

import com.example.electricitybill.entity.SlabReading;
import com.example.electricitybill.repository.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SlabService {
    @Autowired
    private SlabRepository slabRepository;
    public String addSlab(SlabReading slabReading){
        slabRepository.save(slabReading);
        return "slabSaved";
    }
    public List<SlabReading> getSlab(){
       return slabRepository.findAll();
    }

    public List<SlabReading> findAllSlab(){
        return slabRepository.findAll();
    }
}
