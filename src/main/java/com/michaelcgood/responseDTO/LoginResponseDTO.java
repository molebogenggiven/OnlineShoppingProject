package com.michaelcgood.responseDTO;

import org.springframework.stereotype.Component;

@Component
public class LoginResponseDTO {

    private String status;
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
