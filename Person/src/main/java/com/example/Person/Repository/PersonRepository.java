package com.example.Person.Repository;

import com.example.Person.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {
}
