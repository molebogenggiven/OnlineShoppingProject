package com.michaelcgood.requestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


public class CodeDTO {

    @JsonProperty
    private String username;

    @JsonProperty
    private int code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
