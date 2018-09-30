package com.michaelcgood.Controller;

import com.michaelcgood.Exceptions.ResourceNotFoundException;
import com.michaelcgood.Service.TemporaryServices;
import com.michaelcgood.dao.CustomerRepository;
import com.michaelcgood.dao.TemporaryRepository;
import com.michaelcgood.model.Customer;
import com.michaelcgood.model.Product;
import com.michaelcgood.model.TemporaryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TemporaryServices temporaryServices;

    @Autowired
    TemporaryRepository temporaryRepository;

    @PostMapping("/register")
    public Customer registerCustomer(@Valid @RequestBody Customer customer){


        return customerRepository.save(customer);
    }

    @PostMapping("/registerCustomer")
    public ResponseEntity<String> saveCustomerToTempDb(@Valid @RequestBody TemporaryModel temporaryModel){

       if (temporaryModel != null) {

           temporaryServices.saveCustomerTemporaryData(temporaryModel);

       }

       return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("Hello");
    }

    @GetMapping("/resendCode/{code}")
    public ResponseEntity<String> ResendCode(@PathVariable(value ="code") long code ){

      return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("Hello");

    }

    @GetMapping("/validateCode/{code}")
    public ResponseEntity<String> getCode(@PathVariable(value = "code") long code) {

        if(temporaryRepository.existsById((code))){
            TemporaryModel temporaryModel = temporaryRepository.getAllCustomerDetails(code);
            temporaryServices.SaveCustomerToPermanentDatabase(temporaryModel);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Guru");


    }



    @GetMapping("/getCustomer")

    public List<Customer> getCustomer(Customer customer){

        return customerRepository.findAll();
    }


}
