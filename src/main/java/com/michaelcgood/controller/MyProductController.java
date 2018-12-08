package com.michaelcgood.controller;

import com.michaelcgood.Exceptions.ResourceNotFoundException;
import com.michaelcgood.Service.MenService;
import com.michaelcgood.dao.MenRepository;
import com.michaelcgood.dao.ProductRepository;
import com.michaelcgood.model.MenModel;
import com.michaelcgood.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MyProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MenRepository menRepository;

    @Autowired
    MenService menService;


    @GetMapping("/getAllProducts")

    public List<MenModel> getAllProducts(){

         return menRepository.findAll();
     }

     // insert data
     @PostMapping("/product")
    public ResponseEntity<String> insertProduct(@Valid @RequestBody Product product){
         String message = "";


//             if (productRepository.checkIfProductIdExist(product.getProductId()) == product.getProductId()){
//
//                 message = "ProductId :"+product.getProductId() +" already exists," +
//                         "Please make sure you use different productId per product";
//                 return ResponseEntity.status(HttpStatus.OK).body(message);
//
//             }else
                 if("men".equalsIgnoreCase(product.getCategory())) {
                 //productRepository.save(product);
                 menService.saveMenItemToDatabase(product);
                 message = "ProductId :"+ product.getProductId() +" has been added successfully";

                 return ResponseEntity.status(HttpStatus.OK).body(message);

             }else if ("women".equalsIgnoreCase(product.getCategory())){

             }else if("children".equalsIgnoreCase(product.getCategory())){

             }

             return ResponseEntity.status(HttpStatus.OK).body("Product is not added");
//
//           if (product.getCategory() == null){
//
//               return "Product category name can't be null";
//           }else if(product.getProductQuantity() == 0){
//               return "Quantity must be at least 1";
//           }else if(product.getProductName() == null){
//               return "Product name cant be null";
//           }else if (product.getProductSize() == null){
//               return "Product size can't be null";
//           }else if(product.getProductId() == 0){
//               return "Product id must have a value";
//           }else if (product.getPictureData() == null){

               //return "Please provide picture";
//           }else {
//
            //  return   productRepository.save(product);
//               return "Product information have been added successfully";
//           }


     }

     @PutMapping("/product/{product_id}")

    public Product updateProduct(@PathVariable(value = "product_id") Long productId, @Valid
                                @RequestBody Product product) throws ResourceNotFoundException{

        Product product1 = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product1", "product_id", productId));
         product1.setProductName(product.getProductName());
         product1.setProductPrice(product.getProductPrice());
         product1.setProductQuantity(product.getProductQuantity());
         product1.setProductSize(product.getProductSize());

         Product updateProduct = productRepository.save(product1);

         return updateProduct;

     }

    @GetMapping("/singleProduct/{id}")
    public Product getUserById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException{
        return productRepository.findById(productId)

                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteUser(@PathVariable( value = "productId") Long productId) throws ResourceNotFoundException {
        Product productModel = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("productModel", "id", productId));

        productRepository.delete(productModel);

        return ResponseEntity.ok().build();
    }





}
