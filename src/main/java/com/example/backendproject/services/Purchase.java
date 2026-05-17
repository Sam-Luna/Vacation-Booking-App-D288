package com.example.backendproject.services;

import com.example.backendproject.entities.Cart;
import com.example.backendproject.entities.CartItem;
import com.example.backendproject.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
