package com.michaelcgood.controller;

import com.michaelcgood.Exceptions.User;
import com.michaelcgood.Service.NotificationService;
import com.michaelcgood.model.Customer;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/registrations")
public class RegistrationController {

    //Bean bean = new Bean();

    @Autowired
    //@Qualifier("notificationService")
    private NotificationService notificationService;

    @PostMapping("/registration")
    public String signup(@Valid @RequestBody Customer customer){


        User user = new User();
        user.setFirstName(customer.getFirstName());
        user.setLastName(customer.getLastName());
        user.setEmailAdress(customer.getUsername());
        user.setPassword(customer.getPassword());
        user.setPasswordVerify(customer.getPasswordVerify());

        try{

            notificationService.sendNotification(user);

        }catch (Exception e){

            System.out.println("Something went wrong");

        }

        return "Thanks for sending an email";
    }


    //@PostMapping("/register")
    @RequestMapping("/sendMAil")
    public String signupSuccess(){
       // @Valid @RequestBody String customer
        JSONObject jsonObject = new JSONObject();
        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        //jsonObject.get("firstname");

        User user = new User();
        user.setFirstName("Given");
        user.setLastName("Kubyana");
        user.setEmailAdress("givenkubjana@gmail.com");

        try{

            notificationService.sendNotification(user);

        }catch (Exception e){

        }

        return "You have successfully sent email";
    }




}
