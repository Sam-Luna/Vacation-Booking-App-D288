package com.example.backendproject.Bootstrap;

import com.example.backendproject.dao.CustomerRepository;
import com.example.backendproject.dao.DivisionRepository;
import com.example.backendproject.entities.Customer;
import com.example.backendproject.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }
    //sample inventory
    @Override
    public void run(String... args) throws Exception {
        /*only works if the repository has only one or less custumers*/
        if(customerRepository.count() <= 1){

            /*I created and saved a division to repo*/
            Division pennsylvania = new Division();
            pennsylvania.setDivision_name("Pennsylvania");
            pennsylvania.setCountry_id(1L);
            Division divisionSaved = divisionRepository.save(pennsylvania);

            //I created all 5 sample customers
            Customer charlie = new Customer();
            Customer Deandra = new Customer();
            Customer Mac = new Customer();
            Customer Frank = new Customer();
            Customer Dennis = new Customer();

            //I added the necessary fields to each customer
            charlie.setFirstName("Charlie");
            charlie.setLastName("Kelly");
            charlie.setAddress("5077 Philadephia Ave.");
            charlie.setPostal_code("24687");
            charlie.setPhone("7145762531");
            charlie.setDivision(pennsylvania);
            Customer charlieSaved = customerRepository.save(charlie);
            charlieSaved.setDivision(divisionSaved);


            Deandra.setFirstName("Deandra");
            Deandra.setLastName("Reynolds");
            Deandra.setAddress("5077 Philadephia Ave.");
            Deandra.setPostal_code("24687");
            Deandra.setPhone("7145762531");
            Deandra.setDivision(pennsylvania);
            Customer deandraSaved = customerRepository.save(Deandra);
            deandraSaved.setDivision(divisionSaved);

            Mac.setFirstName("Mac");
            Mac.setLastName("Donald");
            Mac.setAddress("5077 Philadephia Ave.");
            Mac.setPostal_code("24687");
            Mac.setPhone("7145762531");
            Mac.setDivision(pennsylvania);
            Customer macSaved = customerRepository.save(Mac);
            macSaved.setDivision(divisionSaved);

            Frank.setFirstName("Frank");
            Frank.setLastName("Reynolds");
            Frank.setAddress("5077 Philadephia Ave.");
            Frank.setPostal_code("24687");
            Frank.setPhone("7145762531");
            Frank.setDivision(pennsylvania);
            Customer frankSaved = customerRepository.save(Frank);
            frankSaved.setDivision(divisionSaved);

            Dennis.setFirstName("Dennis");
            Dennis.setLastName("Reynolds");
            Dennis.setAddress("5077 Philadephia Ave.");
            Dennis.setPostal_code("24687");
            Dennis.setPhone("7145762531");
            Dennis.setDivision(pennsylvania);
            Customer dennisSaved = customerRepository.save(Dennis);
            dennisSaved.setDivision(divisionSaved);
        }
        System.out.println("In bootstrap: ");
        System.out.println(customerRepository.findAll());

    }
}
