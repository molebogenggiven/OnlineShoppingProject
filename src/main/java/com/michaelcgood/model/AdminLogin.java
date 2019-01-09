package com.michaelcgood.model;

import com.michaelcgood.parentClasses.Login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "admin_login_table")
public class AdminLogin extends Login implements Serializable {


    @Id
    @NotNull
    @Column
    @Override
    public String getUsername() {
        return super.getUsername();
    }


    @NotNull
    @Column
    @Override
    public String getPassword() {
        return super.getPassword();
    }
}
