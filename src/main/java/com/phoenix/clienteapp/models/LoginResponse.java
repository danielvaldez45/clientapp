package com.phoenix.clienteapp.models;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class LoginResponse {

    private Integer code;
    private String message;
    private User user;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
