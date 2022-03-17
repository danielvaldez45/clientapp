package com.phoenix.clienteapp.http;

import com.phoenix.clienteapp.model.Auth;

public class LoginRequest {

    private Auth auth;

    public LoginRequest(Auth auth) {
        this.auth = auth;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "LoginRequest{" + "auth=" + auth + '}';
    }

}
