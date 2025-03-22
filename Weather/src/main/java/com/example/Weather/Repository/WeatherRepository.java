package com.example.Weather.Repository;

import com.example.Weather.dto.Person;
import com.example.Weather.dto.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WeatherRepository extends CrudRepository<Weather,Integer> {
}
