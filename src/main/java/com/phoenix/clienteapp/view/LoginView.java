package com.phoenix.clienteapp.view;

import com.phoenix.clienteapp.controller.LoginController;
import com.phoenix.clienteapp.model.Auth;
import java.io.IOException;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Named("viewLogin")
@RequestScoped
public class LoginView implements Serializable {

    private Auth loginAuth;
    private String requestedURI;

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

    public void requestLogin() throws IOException {
        //Contexto actual de la aplicacion.
        FacesContext contextFaces = FacesContext.getCurrentInstance();

        //Creo un objeto request a partir del contexto de la aplicacion.
        HttpServletRequest request = (HttpServletRequest) contextFaces.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) contextFaces.getExternalContext().getResponse();

        //Me loggeo en el sistema (backend)
        Auth auth = loginController.requestLogin(loginAuth);

        if (!auth.getToken().isEmpty() && auth != null) {
            System.out.println("Hola mundo");

            HttpSession session = (HttpSession) contextFaces.getExternalContext().getSession(true);
            session.setAttribute("sesion", auth);

            contextFaces.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Acceso concedido. Bienvenido: " + auth.getUsername()));

            response.sendRedirect("app/home.xhtml");
            //return "/app/product.xhtml?facesRedirect=true";
            //return "/app/product.xhtml";
        } else {
            contextFaces.addMessage(null, new FacesMessage("Credenciales incorrectas"));
            loginAuth.setUsername(null);
            loginAuth.setPassword(null);
        }
    }

}
