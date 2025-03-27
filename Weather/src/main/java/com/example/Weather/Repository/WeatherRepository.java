package com.example.Weather.Repository;

import com.example.Weather.model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WeatherRepository extends CrudRepository<Weather,Integer> {
}
