package com.phoenix.clienteapp.dao.rest;

import com.phoenix.clienteapp.http.LoginRequest;
import com.phoenix.clienteapp.http.LoginResponse;
import com.phoenix.clienteapp.http.RegisterRequest;
import com.phoenix.clienteapp.http.RegisterResponse;
import com.phoenix.clienteapp.model.Auth;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
//import org.primefaces.shaded.json.JSONObject;

/**
 *
 * Esta clase sirve para hacer peticiones al backend mediante el consumo de
 * apiREST.
 *
 */
@ApplicationScoped
public class LoginDAO implements Serializable {

    private String url_server;
    private String base_url;
    private Response response;

    public LoginDAO() {
        //Parametros de configuracion
        this.url_server = "http://localhost:8181";
        this.base_url = url_server;
    }

    /**
     * Inicia una sesion en el sistema.
     *
     * @param request {LoginRequest} Representa un objeto de tipo LoginRequest.
     * @return true {boolean} Devuelve true si el usuario esta registrado en el
     * sistema.
     */
    public Auth login(LoginRequest request) {
        Auth auth = new Auth();
        try {
            String endpoint = "/login";
            String uri = base_url + endpoint;
            
            Client client = ClientBuilder.newClient();
            WebTarget resourceTarget = client.target(uri);

            response = resourceTarget
                    .request()
                    .post(Entity.entity(request, "application/json"));

            if (response.getStatus() == 200) {
                //Extraer la informacion del cuerpo y lo settea en un objeto de tipo Auth.
                LoginResponse loginResponse = response.readEntity(LoginResponse.class);
                //System.out.println(loginResponse.getAuth().toString());

                if (loginResponse.getCode() == 102) {
                    return loginResponse.getAuth();
                }

            }
            return auth;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return auth;
    }

    /* *
       * Sirve para registrar un nuevo usuario en el sistema  
       * */
    public boolean register(RegisterRequest request) {
        String endpoint = "/register";
        String URI = base_url + endpoint;

        Client client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target("http://localhost:8181/register");

        response = resourceTarget
                .request()
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));

        if (response.getStatus() == 201) {
            RegisterResponse registerResponse = response.readEntity(RegisterResponse.class);

            if (registerResponse.getCode() == 100) {
                return true;
            }
        }
        return false;
    }
}
