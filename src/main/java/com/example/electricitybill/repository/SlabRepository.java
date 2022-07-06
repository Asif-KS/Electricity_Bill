package com.example.electricitybill.repository;

import com.example.electricitybill.entity.SlabReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SlabRepository extends JpaRepository<SlabReading ,Integer> {
}
