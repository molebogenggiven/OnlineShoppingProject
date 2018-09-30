package com.michaelcgood.dao;


import com.michaelcgood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

//    @Query("SELECT productId FROM Product p where p.productId = :productId")
//    long checkIfProductIdExist(@Param("productId") long productId);

}
