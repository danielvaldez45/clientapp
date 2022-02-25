package com.phoenix.clienteapp.controllers;

import com.phoenix.clienteapp.DAO.clientREST.AuthDAO;
import com.phoenix.clienteapp.models.User;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class LoginController {

    AuthDAO auth;

    boolean requestLogin() {
        return auth.login(new User("daniel210", "password"));
    }
}
