package com.example.Location.Repository;

import com.example.Location.dto.Location;
import com.example.Location.dto.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LocationRepository extends CrudRepository<Location,Integer> {
}
