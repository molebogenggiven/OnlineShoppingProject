package com.michaelcgood.Controller;

import com.michaelcgood.dao.ProductRepository;
import com.michaelcgood.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyProductController {

    @Autowired
    ProductRepository productRepository;

     @GetMapping("/getAllproducts")

    public List<Product> getAllProducts(){

         return productRepository.findAll();
     }

     // insert data
     @PostMapping("/product")
    public Product insertProduct(@Valid @RequestBody Product product){

            return productRepository.save(product);

     }

     @PutMapping("/product/{product_id}")

    public Product updateProduct(@PathVariable(value = "product_id") Long productId, @Valid
                                 @RequestBody Product product){

         Product product1 = productRepository.findOne(productId);
                 //.orElseThrow(() -> new ResourceNotFoundException("product1", "product_id", productId));
         product1.setProductName(product.getProductName());
         product1.setProductPrice(product.getProductPrice());
         product1.setProductQuantity(product.getProductQuantity());
         product1.setProductSize(product.getProductSize());

         Product updateProduct = productRepository.save(product1);

         return updateProduct;

     }




}
