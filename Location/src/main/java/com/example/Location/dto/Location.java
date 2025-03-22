package com.example.Location.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Location {
   @Getter @Setter @Id @GeneratedValue private int id;
   @Getter @Setter private int seaLevel;
   @Getter @Setter private String name;
   @Getter @Setter private int grandLevel;


   @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)

   @Getter @Setter private List<Weather> weathers = new ArrayList<>();





}
