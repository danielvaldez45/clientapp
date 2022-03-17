package com.phoenix.clienteapp.http;

import com.phoenix.clienteapp.model.Auth;

public class LoginResponse {

    private Integer code;
    private String message;
    private Auth auth;

    public LoginResponse() {
    }

    public LoginResponse(Integer code, String message, Auth auth) {
        this.code = code;
        this.message = message;
        this.auth = auth;
    }

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

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "LoginResponse{" + "code=" + code + ", message=" + message + ", auth=" + auth + '}';
    }

}
