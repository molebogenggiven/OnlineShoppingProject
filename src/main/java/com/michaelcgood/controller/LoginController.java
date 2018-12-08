package com.michaelcgood.controller;

import com.michaelcgood.Exceptions.ResourceNotFoundException;
import com.michaelcgood.dao.LoginRepository;
import com.michaelcgood.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginRepository loginRepository;



    @PostMapping("/loginUser")

    public String userLogin(@Valid @RequestBody Login login){


        if(loginRepository.findUserByUsernameAndPassword(login.getUsername(),
                login.getPassword()) != null){

            return "success";
        }else if(loginRepository.findUserByUsernameAndPassword(login.getUsername(),
                login.getPassword()) == null){
            return "failed";
        }


        return null;}

    @GetMapping("/findUsers")
    public List<Login> getAllProducts(){

        return loginRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Login> getUserById(@PathVariable(value = "id") String username) throws Exception{
        Login user = loginRepository.findById(username)

                .orElseThrow(() -> new ResourceNotFoundException("Login", "id", username));

        return ResponseEntity.ok().body(user);
    }
}
