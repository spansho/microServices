package com.example.Location.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    @Getter @Setter @Id
    @GeneratedValue
    private int id;
    @Getter @Setter double temp;
    @Getter @Setter double tempMin;
    @Getter @Setter double tempMax;
    @Getter @Setter int presure;
    @Getter @Setter int humidity;
    @Getter @Setter double feelsLike;


    @OneToOne
    private Location location;
}
