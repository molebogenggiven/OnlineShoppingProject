package com.michaelcgood.parentClasses;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Login {


    protected String username;

    protected String password;


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Login(){}

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }



}
