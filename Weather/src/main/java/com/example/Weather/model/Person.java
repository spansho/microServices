package com.example.Weather.model;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter @Setter @Id @GeneratedValue
    private int id;
    @Getter @Setter @NonNull String name;
    @Getter @Setter @NonNull String location;


}
