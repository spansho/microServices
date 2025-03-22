package com.example.Location.dto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter @Setter @Id @GeneratedValue
    private int id;
    @Getter @Setter @NonNull String name;
    @Getter @Setter @NonNull String location;


}
