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
import org.glassfish.jersey.inject.hk2.RequestContext;

@Named("viewLogin")
@RequestScoped
public class LoginView implements Serializable {
    
    private Auth userCredentials;
    private String requestedURI;
    
    @Inject
    private LoginController loginController;
    
    public LoginView() {
        this.userCredentials = new Auth();
    }
    
    public Auth getLoginUser() {
        return userCredentials;
    }
    
    public void setLoginUser(Auth userCredentials) {
        this.userCredentials = userCredentials;
    }
    
    public void newLogin() {
        this.userCredentials = new Auth();
    }
    
    public String requestLogin() throws IOException {
        //Contexto actual de la aplicacion.
        FacesContext contextFaces = FacesContext.getCurrentInstance();

        //Creo un objeto request a partir del contexto de la aplicacion.
        HttpServletRequest request = (HttpServletRequest) contextFaces.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) contextFaces.getExternalContext().getResponse();

        //Me loggeo en el sistema (backend)
        Auth auth = loginController.requestLogin(userCredentials);
        System.out.println(auth.toString());
        if (!auth.getToken().isEmpty() && auth != null) {
            System.out.println("Hola mundo");
            
            HttpSession session = (HttpSession) contextFaces.getExternalContext().getSession(false);
            session.setAttribute("sesion", auth);
            
            contextFaces.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Acceso concedido. Bienvenido: " + auth.getUsername()));
            //            response.sendRedirect("app/home.xhtml");

            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/mavenproject3/app/home.xhtml");
//            return "/app/home.xhtml?facesRedirect=true";
            //return "/app/product.xhtml";
        } else {
            contextFaces.addMessage(null, new FacesMessage("Credenciales incorrectas"));
            userCredentials.setUsername(null);
            userCredentials.setPassword(null);
        }
        return "/app/home.xhtml?facesRedirect=true";
    }
    
}
