package com.michaelcgood.controller;

import com.michaelcgood.Exceptions.ResourceNotFoundException;
import com.michaelcgood.Service.TemporaryServices;
import com.michaelcgood.dao.TemporaryRepository;
import com.michaelcgood.model.TemporaryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {

  //  @Autowired
    //CustomerRepository customerRepository;

    @Autowired
   TemporaryServices temporaryServices;

    @Autowired
    TemporaryRepository temporaryRepository;

//    @PostMapping("/register")
//    public Customer registerCustomer(@Valid @RequestBody Customer customer){
//
//
//        return customerRepository.save(customer);
//    }

    @PostMapping("/submitVerificationCode")
    public ResponseEntity<String> verifyCode(@Valid @RequestBody TemporaryModel temporaryModel){

        if (temporaryRepository.verifyUsernameAndCode(temporaryModel.getUsername(), temporaryModel.getCode()) != null){
            TemporaryModel temporaryModel1 = temporaryRepository.getCustomerDatails(temporaryModel.getUsername());
            System.out.println(temporaryModel1.getStatus().equals("InProgress"));
            if (temporaryModel1.getStatus().equals("InProgress")){
                temporaryRepository.updateStatus(temporaryModel.getUsername(), "Active");
                return ResponseEntity.status(HttpStatus.OK).body("You  have successfully Registered");
            }else if (temporaryModel1.getStatus().equals("Active")) {
                return ResponseEntity.status(HttpStatus.OK).body("You have already registred");
            }

        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Please Verify Your Code");
        }
            return null;
    }

    @PostMapping("/registerCustomer")
    public String saveCustomerToTempDb(@Valid @RequestBody TemporaryModel temporaryModel){

//       if (temporaryModel != null) {

           temporaryServices.saveCustomerTemporaryData(temporaryModel);
               return "You Have Successfully Registered";
//           }else {
//               return "You Have Already Registered";
//           }

//       }
//
//       return "Please Send Your Details Again";
    }

    @GetMapping("/resendCode/{code}")
    public ResponseEntity<String> ResendCode(@PathVariable(value ="code") long code ){

      return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("Hello");

    }

    @GetMapping("/validateCode/{code}")
    public ResponseEntity<String> getCode(@PathVariable(value = "code") long code) {

//        if(temporaryRepository.existsById((code))){
//            TemporaryModel temporaryModel = temporaryRepository.getAllCustomerDetails(code);
//            temporaryServices.SaveCustomerToPermanentDatabase(temporaryModel);
//        }

        return ResponseEntity.status(HttpStatus.OK).body("Guru");


    }



    @GetMapping("/singleCustomer/{id}")
    public TemporaryModel getUserById(@PathVariable(value = "id") String username) throws ResourceNotFoundException{
        return temporaryRepository.findById(username)

                .orElseThrow(() -> new ResourceNotFoundException("User", "id", username));
    }

}
