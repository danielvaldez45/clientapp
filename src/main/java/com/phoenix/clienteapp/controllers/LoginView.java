package com.phoenix.clienteapp.controllers;

import com.phoenix.clienteapp.dao.clientREST.LoginDao;
import com.phoenix.clienteapp.models.User;
import com.phoenix.clienteapp.service.LoginService;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ManagedBean
@Named("viewLogin")
@RequestScoped
public class LoginView implements Serializable {

    private User userLogin;
    @Inject
    private LoginDao clientRequest;

    public LoginView() {
        this.userLogin = new User();
    }

    public User getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(User userLogin) {
        this.userLogin = userLogin;
    }

    public void newLogin() {
        this.userLogin = new User();
    }

    public void requestLogin() {
        System.out.print(userLogin.toString());
        boolean userIsRegister = clientRequest.login(this.userLogin);
        if (userIsRegister) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Acceso concedido. Bienvenido: " + this.userLogin.getUsername())
            );

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciales incorrectas"));
        }
    }

    void redirect() {
        // Si me devuelve un true: Redireciona al usuario.
        // Aqui me apoyare de un servlet
        // String site = "http://www.newpage.com";
        //response.setStatus(response.SC_MOVED_TEMPORARILY);
        //response.setHeader("Location", site);
    }
}
