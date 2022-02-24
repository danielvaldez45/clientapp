package com.phoenix.clienteapp.DAO.clientREST;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * Esta clase sirve para hacer peticiones al backend mediante el consumo de apiREST.
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
    public boolean login(String username, String password) {
        if(username == "daniel210" && password == "qwerty210"){
          return true;
        }
        return false;
        //Aqui va mi implementacion para consumir el api
        /*
           Client client = ClientBuilder.newClient();
           client.target("https://gorest.co.in/public/v2/users");
         */
    }
    
    public void Register(){
      //Logica para registrar al usuario
    }
}
