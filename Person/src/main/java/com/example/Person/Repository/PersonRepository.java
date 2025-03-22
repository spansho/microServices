package com.example.Person.Repository;

import com.example.Person.dto.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {
}
