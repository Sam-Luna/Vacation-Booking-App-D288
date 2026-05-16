package com.example.backendproject.dao;

import com.example.backendproject.entities.Excursion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ExcursionRepository extends CrudRepository<Excursion,Long> {
}
