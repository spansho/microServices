package com.example.Person.model;
import com.example.Person.dto.Location;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter @Setter @Id @GeneratedValue
    private int id;
    @Getter @Setter @NonNull String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @Getter @Setter @NonNull
    Location location;
}
