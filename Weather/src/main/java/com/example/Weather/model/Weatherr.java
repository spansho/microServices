package com.example.Weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weatherr{
    private int id;
    private String main;
    private String description;
    private String icon;
}
