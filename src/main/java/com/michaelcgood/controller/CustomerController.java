package com.michaelcgood.controller;

import com.michaelcgood.Exceptions.ResourceNotFoundException;
import com.michaelcgood.Service.TemporaryServices;
import com.michaelcgood.dao.LoginRepository;
import com.michaelcgood.dao.TemporaryRepository;
import com.michaelcgood.model.TemporaryModel;
import com.michaelcgood.model.UserLogin;
import com.michaelcgood.requestDTO.CodeDTO;
import com.michaelcgood.responseDTO.RegistrationDTO;
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
    private TemporaryServices temporaryServices;

    @Autowired
    private TemporaryRepository temporaryRepository;

    @Autowired
    private LoginRepository loginRepository;

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
    public ResponseEntity<?> saveCustomerToTempDb(@Valid @RequestBody TemporaryModel temporaryModel){

           RegistrationDTO registrationDTO = new RegistrationDTO();
           if(temporaryServices.saveCustomerTemporaryData(temporaryModel).contains("Successfully")){

               registrationDTO.setUsername(temporaryModel.getUsername());
               registrationDTO.setCode(temporaryModel.getCode());
               registrationDTO.setStatus("Success");
               return ResponseEntity.ok().body(registrationDTO);
           }else if(temporaryServices.saveCustomerTemporaryData(temporaryModel).contains("progress")){

               TemporaryModel temporaryModelUser = temporaryRepository.getCustomerDatails(temporaryModel.getUsername());
               registrationDTO.setUsername(temporaryModel.getUsername());
               registrationDTO.setStatus("progress");
               registrationDTO.setCode(temporaryModelUser.getCode());

               return ResponseEntity.ok().body(registrationDTO);
           }else if(temporaryServices.saveCustomerTemporaryData(temporaryModel).contains("active")){

               registrationDTO.setUsername(temporaryModel.getUsername());
               registrationDTO.setStatus("active");

               return ResponseEntity.ok().body(registrationDTO);
           }

           return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
}

    @GetMapping("/resendCode")
    public ResponseEntity<String> ResendCode(@PathVariable(value ="code") long code ){
      return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("Hello");

    }

    @PostMapping("/validateCode")
    public ResponseEntity<?> validateCode(@Valid @RequestBody CodeDTO codeDTO) {
            RegistrationDTO registrationDTO = new RegistrationDTO();
            UserLogin userLogin = new UserLogin();
          if(temporaryRepository.verifyUsernameAndCode(codeDTO.getUsername(), codeDTO.getCode()) != null){
             TemporaryModel temporaryModel = temporaryRepository.getCustomerDatails(codeDTO.getUsername());
             temporaryModel.setStatus("Active");
             temporaryRepository.save(temporaryModel);
             userLogin.setUsername(temporaryModel.getUsername());
             userLogin.setPassword(temporaryModel.getPassword());
             loginRepository.save(userLogin);
             registrationDTO.setUsername(codeDTO.getUsername());
             registrationDTO.setStatus("Registered");
             registrationDTO.setCode(1);

             return ResponseEntity.ok().body(registrationDTO);

          }else {

              registrationDTO.setUsername(codeDTO.getUsername());
              registrationDTO.setStatus("Code does not exists");
              registrationDTO.setCode(0);

              return ResponseEntity.ok().body(registrationDTO);
          }


    }



    @GetMapping("/singleCustomer/{id}")
    public TemporaryModel getUserById(@PathVariable(value = "id") String username) throws ResourceNotFoundException{
        return temporaryRepository.findById(username)

                .orElseThrow(() -> new ResourceNotFoundException("User", "id", username));
    }

}
