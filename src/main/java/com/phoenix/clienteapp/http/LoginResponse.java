package com.phoenix.clienteapp.http;

import com.phoenix.clienteapp.model.Auth;

public class LoginResponse {

    private Integer code;
    private String message;
    private Auth data;

    public LoginResponse() {
    }

    public LoginResponse(Integer code, String message, Auth data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Auth getData() {
        return data;
    }

    public void setData(Auth data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginResponse{" + "code=" + code + ", message=" + message + ", data=" + data + '}';
    }

}
