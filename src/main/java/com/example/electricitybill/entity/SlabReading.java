package com.example.electricitybill.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table (name ="SLAB_TBL" )
public class SlabReading {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double initialReading;
    private double finalReading;
    private double slabRate;

}
