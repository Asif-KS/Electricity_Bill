package com.example.electricitybill.repository;

import com.example.electricitybill.entity.Customer;
import com.example.electricitybill.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
//    @Query(value = "SELECT MAX(id) FROM READING_TBL WHERE id=?1" )
//    Reading findByMaxReading(int id);


}
