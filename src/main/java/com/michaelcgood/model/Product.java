package com.michaelcgood.model;

import javax.persistence.*;

@Entity
public class Product {

    private String productname;
    private int productprice;
    private int productquantity;
    private int productsize;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;

    public long getProductId() {
        return id;
    }

    public void setProductid(long productid) {
        this.id = id;
    }


    public String getProductName() {
        return productname;
    }

    public void setProductName(String productname) {
        this.productname = productname;
    }

    public double getProductPrice() {
        return productprice;
    }

    public void setProductPrice(int productprice) {
        this.productprice = productprice;
    }

    public double getProductSize() {
        return productsize;
    }

    public void setProductSize(int productsize) {
        this.productsize = productsize;
    }

    public int getProductQuantity() {
        return productquantity;
    }

    public void setProductQuantity(int productquantity) {
        this.productquantity = productquantity;
    }

    @Override
    public String toString() {

        return " | "+id+" | "+productname;
    }
}
