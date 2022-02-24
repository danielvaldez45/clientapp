package com.phoenix.clienteapp.views;

import com.phoenix.clienteapp.DAO.clientREST.AuthDAO;
import com.phoenix.clienteapp.models.User;
import com.phoenix.clienteapp.service.LoginService;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named("viewLogin")
@RequestScoped
public class LoginView implements Serializable {

    private User userLogin;

    @Inject
    private AuthDAO clientRequest;

    public void newLogin() {
        this.userLogin = new User();
    }

    public void requestLogin() {
        boolean userIsRegister = clientRequest.login(this.userLogin);
        
        if (userIsRegister) {
            
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
