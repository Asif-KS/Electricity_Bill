package com.example.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "READING_TBL")
public class Reading {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  int id;
    private double CurrentReading;
    private double previousReading;
    private LocalDateTime time;
    private double billAmount;
    private double unitConception;
    private int C_id;
}
