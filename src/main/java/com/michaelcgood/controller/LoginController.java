package com.michaelcgood.controller;

import com.michaelcgood.Exceptions.ResourceNotFoundException;
import com.michaelcgood.dao.AdminRepository;
import com.michaelcgood.dao.LoginRepository;
import com.michaelcgood.model.UserLogin;
import com.michaelcgood.requestDTO.LoginRequestDTO;
import com.michaelcgood.responseDTO.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AdminRepository adminRepository;




    @PostMapping("/loginUser")
    public ResponseEntity<?> userLogin(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        if(loginRepository.findUserByUsernameAndPassword(loginRequestDTO.getUsername(),
                loginRequestDTO.getPassword()) != null){


            loginResponseDTO.setStatus("UserSuccessfull");
            loginResponseDTO.setUsername(loginRequestDTO.getUsername());

            return ResponseEntity.ok().body(loginResponseDTO);
        }else if(adminRepository.findAdminByUsernameAndPassword(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        != null){

            loginResponseDTO.setStatus("AdminSuccessfull");
            loginResponseDTO.setUsername(loginRequestDTO.getUsername());

            return ResponseEntity.ok().body(loginResponseDTO);
        }else if(loginRepository.findUserByUsernameAndPassword(loginRequestDTO.getUsername(),
                loginRequestDTO.getPassword()) == null || adminRepository.findAdminByUsernameAndPassword(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()) == null){

            loginResponseDTO.setStatus("Failed");
            loginResponseDTO.setUsername(loginRequestDTO.getUsername());
            return ResponseEntity.ok().body(loginResponseDTO);
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");}

    @GetMapping("/findUsers")
    public List<UserLogin> getAllProducts(){

        return loginRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") String username) throws Exception{
        UserLogin user = loginRepository.findById(username)

                .orElseThrow(() -> new ResourceNotFoundException("Login", "id", username));
        return ResponseEntity.ok().body(user);
    }
}
