package com.michaelcgood.controller;

import com.michaelcgood.dao.CardRepository;
import com.michaelcgood.model.CardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CardRepository cartRepository;
    @PostMapping("/addToCard")
    public ResponseEntity<String> addToCart(@Valid @RequestBody CardModel cardModel){
           if (cardModel != null){
               return ResponseEntity.status(HttpStatus.OK).body("You have successfully added product to cart");
           }else{ // 0712025006
               return ResponseEntity.status(HttpStatus.OK).body("Please add your product again");
           }

    }
}
