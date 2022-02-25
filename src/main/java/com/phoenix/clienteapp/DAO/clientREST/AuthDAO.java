package com.phoenix.clienteapp.DAO.clientREST;

import com.phoenix.clienteapp.models.User;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        Client client;
        Response response;

        String username = user.getUsername();
        String password = user.getPassword();

        client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target("http://192.168.1.62:8181/login");

        response = resourceTarget.request()
                .post(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));
        
        if (response.getStatus() == 200) {
            System.out.print(response.toString());
            System.out.print(response.getMetadata());
        }
        return false;
    }

    public void Register() {
        //Logica para registrar al usuario
    }

}
