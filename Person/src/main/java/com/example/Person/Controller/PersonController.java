package com.example.Person.Controller;

import com.example.Person.Repository.PersonRepository;
import com.example.Person.model.Person;
import com.example.Person.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private RestTemplate restTemplate=new RestTemplate();
    @Autowired
    private PersonRepository repository;

    @GetMapping
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("{id}/weather")
    public ResponseEntity<Weather> getWeather(@PathVariable int id) {
        if (repository.existsById(id)) {
            String location = repository.findById(id).get().getLocation().getName();//под вопросом?
            Weather weather = restTemplate.getForObject("http://localhost:8083/location/weather?name=" + location, Weather.class);
            return new ResponseEntity(weather, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return repository.findById(person.getId()).isPresent()
                ? new ResponseEntity(repository.findById(person.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(repository.save(person), HttpStatus.CREATED);
    }




    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person,@PathVariable int id)
    {
        var personv=repository.findById(person.getId());
        if(personv.isPresent()) {
            personv.get().setId(person.getId());
            personv.get().setName(person.getName());
            personv.get().setLocation(person.getLocation());
            repository.save(personv.get());
            return  new ResponseEntity(personv, HttpStatus.OK);
        }
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable int id)
    {
        var person=repository.findById(id);
        if(person.isPresent()) {
            repository.delete(person.get());
            return  new ResponseEntity<>(null, HttpStatus.OK);
        }
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    //@GetMapping
    //public ResponseEntity<Weather> getWeatherForPersonById(@PathVariable int id,
                                                         //  Locale locale)
   // {
    //    var person = repository.findById(id);
     //   if(person.isPresent()) {
      //      var weather = person.get().getLocation().getWeathers();
      //      return new ResponseEntity<>(weather,HttpStatus.OK);
      //  }
      //  return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//
 //}
}