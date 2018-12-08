package com.michaelcgood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "payment_Table")
public class Payment implements Serializable{

    @Id
    @NotNull
    @Column
    private long cardNumber;

    @NotNull
    @Column
    private String cardName;

    @NotNull
    @Column
    private int secuityCode;

    @NotNull
    @Column
    private String month;

    @NotNull
    @Column
    private int year;

    @NotNull
    @Column
    private String country;

    @NotNull
    @Column
    private double balance;



    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getSecuityCode() {
        return secuityCode;
    }

    public void setSecuityCode(int secuityCode) {
        this.secuityCode = secuityCode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
