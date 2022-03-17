package com.phoenix.clienteapp.view;

import com.phoenix.clienteapp.controller.LoginController;
import com.phoenix.clienteapp.model.Auth;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

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

    public String requestLogin() {
        FacesContext context = FacesContext.getCurrentInstance();

        Auth auth = loginController.requestLogin(loginAuth);

        if (auth.getToken().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciales incorrectas"));
            loginAuth.setUsername(null);
            loginAuth.setPassword(null);
            return "/app/home.xhtml?facesRedirect=true";
        }
        //Settear la sesion
        context.getExternalContext().getSessionMap().put("user_sesion", auth);

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage("Acceso concedido. Bienvenido: " + auth.getUsername()));
        return "/login.xhtml?facesRedirect=true";
    }

}
