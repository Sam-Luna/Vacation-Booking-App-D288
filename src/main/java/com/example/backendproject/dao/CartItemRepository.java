package com.example.backendproject.dao;

import com.example.backendproject.entities.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CartItemRepository extends CrudRepository<CartItem,Long> {
}
