package com.phoenix.clienteapp.controller;

import com.phoenix.clienteapp.DAO.clientREST.AuthDAO;
import com.phoenix.clienteapp.model.User;
import com.phoenix.clienteapp.service.LoginService;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named("viewLogin")
@RequestScoped
public class LoginController {

    private User userLogin;
    

    @Inject
    private AuthDAO clientRequest;
   
    void newLogin(){
        this.userLogin = new User();
    }
    
    public void requestLogin(String username, String password) throws IOException {
        if (clientRequest.login(username, password)) {
            //Si me devuelve un true: Redireciona al usuario.
            //Aqui me apoyare de un servlet
//            String site = "http://www.newpage.com";
//            response.setStatus(response.SC_MOVED_TEMPORARILY);
//            response.setHeader("Location", site);
            
        }
        // Si es un false muestra un menjsaje
    }
}
