package com.phoenix.clienteapp.view;

import com.phoenix.clienteapp.controller.LoginController;
import com.phoenix.clienteapp.model.Auth;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

//@ManagedBean
@Named("viewLogin")
@RequestScoped
public class LoginView implements Serializable {

    private Auth loginAuth;

    @Inject
    private LoginController loginController;

    public LoginView() {
        this.loginAuth = new Auth();
    }

    public Auth getLoginUser() {
        return loginAuth;
    }

    public void setLoginUser(Auth loginAuth) {
        this.loginAuth = loginAuth;
    }

    public void newLogin() {
        this.loginAuth = new Auth();
    }

    public void requestLogin() {
        boolean userIsRegister = loginController.requestLogin(loginAuth);
        if (userIsRegister) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Acceso concedido. Bienvenido: " + loginAuth.getUsername())
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
