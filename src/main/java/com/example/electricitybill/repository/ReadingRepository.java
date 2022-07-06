package com.example.electricitybill.repository;

import com.example.electricitybill.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReadingRepository extends JpaRepository<Reading,Integer> {
    @Query(value = "Select * From READING_TBL WHERE c_id=:cid ORDER By Id DESC LIMIT 1",nativeQuery = true)
    Reading getPreviousReading(@Param("cid")int cid);



}
