package com.phoenix.clienteapp.http;

import com.phoenix.clienteapp.model.Auth;

public class LogoutRequest {

    private Auth auth;

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

}
