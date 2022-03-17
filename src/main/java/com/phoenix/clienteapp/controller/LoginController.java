package com.phoenix.clienteapp.controller;

import com.phoenix.clienteapp.dao.rest.LoginDAO;
import com.phoenix.clienteapp.http.LoginRequest;
import com.phoenix.clienteapp.http.LoginResponse;
import com.phoenix.clienteapp.http.RegisterRequest;
import com.phoenix.clienteapp.model.Auth;
import com.phoenix.clienteapp.model.User;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel
 */
public class LoginController {

    private LoginRequest request;
    private LoginResponse response;
    private Auth auth;

    /*public boolean requestLogin(User user) {
        return true;
    }*/
    /**
     * @param loginAuth {Auth} - Representa una peticion para una sesion.
     * @return auth {Auth} - Este metodo devuelve un objecto auth que representa
     * una sesion del usuario.
     *
     */
    public Auth requestLogin(Auth loginAuth) {
        LoginRequest request = new LoginRequest(loginAuth);
        return new LoginDAO().login(request);
    }

    public boolean requestRegister(User registerUser) {
        RegisterRequest request = new RegisterRequest(registerUser);
        boolean isSuccess = new LoginDAO().register(request);
        //Aqui setteare el token en el localstorage
        return isSuccess;
    }
}
