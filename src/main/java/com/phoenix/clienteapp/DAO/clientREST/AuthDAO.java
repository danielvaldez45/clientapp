package com.phoenix.clienteapp.DAO.clientREST;

import com.phoenix.clienteapp.models.User;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * Esta clase sirve para hacer peticiones al backend mediante el consumo de
 * apiREST.
 *
 */
@ApplicationScoped
public class AuthDAO {

    private String username;
    private String password;
    private String url;

    AuthDAO() {
        //Parametros de configuracion
        this.url = url;
    }

    //Get Request
    //POST Request: Mando una peticion parametrizada
    public boolean login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        
        if (username == "daniel210" && password == "qwerty210") {
            return true;
        }
        //Aqui va mi implementacion para consumir el api

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8080/login");

        String response = myResource.request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        return false;
    }

    public void Register() {
        //Logica para registrar al usuario
    }

}
