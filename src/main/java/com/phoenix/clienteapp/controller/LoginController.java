package com.phoenix.clienteapp.controller;

import com.phoenix.clienteapp.dao.rest.LoginDAO;
import com.phoenix.clienteapp.http.LoginRequest;
import com.phoenix.clienteapp.http.LoginResponse;
import com.phoenix.clienteapp.model.Auth;

/**
 *
 * @author daniel
 */
public class LoginController {

    private LoginRequest request;
    private LoginResponse response;

    /*public boolean requestLogin(User user) {
        return true;
    }*/
    public boolean requestLogin(Auth loginAuth) {
        LoginRequest request = new LoginRequest(loginAuth.getUsername(), loginAuth.getPassword());
        boolean isSuccess = new LoginDAO().login(request);
        //Aqui setteare el token en el localstorage
        return isSuccess;
    }
}
