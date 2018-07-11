package com.michaelcgood.Controller;

import com.michaelcgood.dao.CustomerRepository;
import com.michaelcgood.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository

    @PostMapping("/register")
    public Customer registerCustomer(@Valid @RequestBody Customer customer){


        return customerRepository.save(customer);
    }


}
