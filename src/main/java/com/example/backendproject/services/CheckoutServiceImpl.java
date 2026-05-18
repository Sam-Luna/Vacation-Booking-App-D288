package com.example.backendproject.services;

import com.example.backendproject.dao.CustomerRepository;
import com.example.backendproject.entities.Cart;
import com.example.backendproject.entities.CartItem;
import com.example.backendproject.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve order and customer info from dto
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();

        //populate customer with cart
        customer.add(cart);

        //populate Cart with CartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // generate tracking number and set to cart item
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //check if cart OR cartItems are null OR if cartItems is empty
        if(cart == null || cartItems.isEmpty() || cartItems == null ){
            orderTrackingNumber = "Cart cannot be empty!";
        }

        //save to database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    // this will create the tracking # that will be passed to PurchaseResponse
    private String generateOrderTrackingNumber() {
        //generate random UUID
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}