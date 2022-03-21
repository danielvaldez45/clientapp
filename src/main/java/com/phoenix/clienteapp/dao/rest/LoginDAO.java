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
        Auth data = new Auth();

        String endpoint = "/login";
        String requestedURI = base_url + endpoint;

        Client client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target(requestedURI);

        response = resourceTarget
                .request()
                .post(Entity.entity(request, "application/json"));

        if (response.getStatus() == 200) {

            LoginResponse loginResponse = response.readEntity(LoginResponse.class);

            if (loginResponse.getCode() == 102) {
                return loginResponse.getData();
            }
        }
        return data;
    }

    /**
     * Sirve para registrar un nuevo usuario en el sistema
     *
     *
     */
    public boolean register(RegisterRequest request) {
        String endpoint = "/register";
        String requestedURI = base_url + endpoint;

        Client client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target(requestedURI);

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

    /**
     * Obtiene la data de las respuesta.
     *
     * @param response {Response} Es un objeto de tipo respuesta.
     * @return Auth {Auth} Representa un objeto de tipo autenticacion.
     *
     */
    /*public Auth getDataResponse(LoginResponse response) {

        if (loginResponse.getCode() == 102) {
            return loginResponse.getData();
        }
        return null;
    }*/
}
