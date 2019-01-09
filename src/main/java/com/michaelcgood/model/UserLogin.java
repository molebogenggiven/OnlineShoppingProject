package com.michaelcgood.model;

import com.michaelcgood.parentClasses.Login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name ="user_login_table")
public class UserLogin extends Login implements Serializable {
    @Id
    @NotNull
    @Column
    private String username;

    @NotNull
    @Column
    private String password;


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

    public UserLogin(){}

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
