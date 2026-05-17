package com.example.backendproject.dao;

import com.example.backendproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
// Forces the backend to answer the broken URL path the frontend is sending
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
