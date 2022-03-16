package com.phoenix.clienteapp.view;

import com.phoenix.clienteapp.controller.LoginController;
import com.phoenix.clienteapp.model.Auth;
import com.phoenix.clienteapp.model.User;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;

//@ManagedBean
@Named("viewRegister")
@RequestScoped
public class RegisterView implements Serializable {

    private User registerUser;
    private Auth auth;

    @Inject
    private LoginController loginController;

    public RegisterView() {
        this.registerUser = new User();
    }

    public User getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(User registerUser) {
        this.registerUser = registerUser;
    }

    public void newRegister() {
        this.registerUser = new User();
    }

    public void requestRegister() {

        boolean userIsRegister = loginController.requestRegister(registerUser);
        if (userIsRegister) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Usuario registrado correctamente. Inicia sesion para continuar: " + this.registerUser.getUsername())
            );

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error, no se pudo registrar el usuario."));
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
