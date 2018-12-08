package com.michaelcgood.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "cart_table")
public class CardModel implements Serializable{


    @Id
    @Column
    private long productId;

    @NotNull
    @Column
    private String productName;

    @NotNull
    @Column
    private double productPrice;



    @NotNull
    @Column
    private int productQuantity;

    @NotNull
    @Column
    private String productSize;

    @Lob
    @NotNull
    @Column
    private String pictureData;

    @NotNull
    @Column
    private String category;

    @NotNull
    @Column
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getPictureData() {
        return pictureData;
    }

    public void setPictureData(String pictureData) {
        this.pictureData = pictureData;
    }

    public String getCategory() {
        return category;
    }

    public void setCategoty(String category) {
        this.category = category;
    }

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

    public CardModel(){} // default constructor
    public CardModel(long productId, String productName, double productPrice, int productQuantity,String productSize, String pictureData, String category) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productSize = productSize;
        this.pictureData = pictureData;
        this.category = category;
    }


}
