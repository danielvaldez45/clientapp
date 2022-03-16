package com.phoenix.clienteapp.dao.rest;

import com.phoenix.clienteapp.http.LoginRequest;
import com.phoenix.clienteapp.http.LoginResponse;
import com.phoenix.clienteapp.http.RegisterRequest;
import com.phoenix.clienteapp.http.RegisterResponse;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.primefaces.shaded.json.JSONObject;

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
        this.url_server = "http:localhost:8181/login";
        this.base_url = url_server;
    }

    /**
     * Inicia una sesion en el sistema.
     *
     * @param request {LoginRequest} Representa un objeto de tipo LoginRequest.
     * @return true {boolean} Devuelve true si el usuario esta registrado en el
     * sistema.
     */
    public boolean login(LoginRequest request) {

        String endpoint = "/login";
        String uri = base_url + endpoint;
        System.out.println(uri);

        Client client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target("http://localhost:8181/login");

        response = resourceTarget
                .request()
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));

        if (response.getStatus() == 200) {
            //Extraer la informacion del cuerpo y lo settea en un objeto de tipo Auth.
            LoginResponse loginResponse = response.readEntity(LoginResponse.class);
            System.out.println(loginResponse.getAuth().toString());

            if (loginResponse.getCode() == 102) {
                return true;
            }

        }
        return false;
    }

    /* *
       * Sirve para registrar un nuevo usuario en el sistema  
       * */
    public boolean Register(RegisterRequest request) {
        String endpoint = "/register";
        String URI = base_url + endpoint;

        Client client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target(URI);

        response = resourceTarget
                .request()
                .post(Entity.entity(RegisterRequest.class, MediaType.APPLICATION_JSON_TYPE));

        if (response.getStatus() == 200) {
            RegisterResponse res = response.readEntity(RegisterResponse.class);
            JSONObject jsonRes = new JSONObject(res);

            if (jsonRes.getInt("code") == 100) {

                return true;
            }
        }
        return false;
    }
}
