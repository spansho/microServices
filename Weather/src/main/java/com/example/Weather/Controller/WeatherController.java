package com.example.Weather.Controller;

import com.example.Weather.Repository.WeatherRepository;
import com.example.Weather.model.Main;
import com.example.Weather.model.Root;
import com.example.Weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.OutputStream;
import java.util.Optional;

@RestController
@RequestMapping
@EnableCaching
public class WeatherController {

    @Autowired
    private WeatherRepository repository;


    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${appid}")
    private String appId;
    @Value("${url.weather}")
    private String urlWeather;

    @GetMapping("/{id}")
    public Optional<Weather> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Weather> save(@RequestBody Weather weather) {
        return repository.findById(weather.getId()).isPresent()
                ? new ResponseEntity(repository.findById(weather.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(repository.save(weather), HttpStatus.CREATED);
    }

    @Cacheable(value = "cacheManager", key = "{#lat, #lon}")
    @GetMapping("/weather")
    public Main getWeather(@RequestParam String lat, @RequestParam String lon,
                           OutputStream outputStream) {
        String request = String.format("%s?lat=%s&lon=%s&units=metric&appid=%s",
                urlWeather, lat, lon, appId);
        System.out.println("Зашли");
        return restTemplate.getForObject(request, Root.class).getMain();
    }
}