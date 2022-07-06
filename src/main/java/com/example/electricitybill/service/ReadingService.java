package com.example.electricitybill.service;

import com.example.electricitybill.entity.Customer;
import com.example.electricitybill.entity.Reading;
import com.example.electricitybill.entity.SlabReading;
import com.example.electricitybill.repository.CustomerRepository;
import com.example.electricitybill.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReadingService {
    @Autowired
    private ReadingRepository repository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SlabService slabService;
   

    public Customer saveReading(int id,Reading reading){
        double billAmount = 0;
        double unitOfConception;

        Reading reading1= new Reading();
        reading1.setCurrentReading(reading.getCurrentReading());
        reading1.setTime(LocalDateTime.now());

        Reading reading2=repository.getPreviousReading(id);

        List<SlabReading> slabList= slabService.findAllSlab();
        if(reading2==null){
            reading1.setPreviousReading(0.0);
            unitOfConception = reading.getCurrentReading();
        }
        else {
            unitOfConception=reading.getCurrentReading()-reading2.getCurrentReading();
            reading1.setPreviousReading(reading2.getCurrentReading());
        }


        SlabReading slabValue=new SlabReading();
        System.out.println(slabList);
        for( int i=0; i<slabList.size();i++){
            slabValue= slabList.get(i);
            System.out.println(slabValue);
            if(slabValue.getInitialReading() <=unitOfConception && unitOfConception<=slabValue.getFinalReading()){
              billAmount=unitOfConception * slabValue.getSlabRate();
                System.out.println(slabValue.getSlabRate());
              break;
            };
        }
        reading1.setBillAmount(billAmount);
        reading1.setUnitConception(unitOfConception);
        Customer customer=customerRepository.findById(id);
        System.out.println(customer);
        reading1.setC_id(customer.getId());
        System.out.println(reading1);

        customer.getReadingSet().add(reading1);
        return  customerRepository.save(customer);

    }
    public List<Reading> saveReadings(List<Reading> readings){
        return repository.saveAll(readings);
    }
    public List<Reading> getReadings(){
        return repository.findAll();
    }
    public Reading getReadingById(int id){
        return repository.findById(id).orElse(null);
    }
    public String deleteReading(int id){
        repository.deleteById(id);
        return "Reading removed||"+id;
    }

//    public Reading lastBill (int id){
//        return customerRepository.findByMaxReading(id);
//}


}
