package com.michaelcgood.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="product_id")
    private long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "product_quantity")
    private int productQuantity;
    @Column(name = "product_size")
    private String productSize;



    public long getProductId() {
        return productId;
    }

    public void setProductid(long productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productquantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {

        return " | "+productId+" | "+productName +" | "+ productPrice +" | "+productQuantity+" | "+" | "+productSize;
    }
}
