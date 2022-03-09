package com.phoenix.clienteapp.dao.clientREST;

import com.phoenix.clienteapp.models.LoginRequest;
import com.phoenix.clienteapp.models.LoginResponse;
import com.phoenix.clienteapp.models.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jdk.nashorn.internal.parser.JSONParser;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * Esta clase sirve para hacer peticiones al backend mediante el consumo de
 * apiREST.
 *
 */
@ApplicationScoped
public class LoginDao implements Serializable {

    private String username;
    private String password;
    private String url;

    LoginDao() {
        //Parametros de configuracion
        this.url = url;
    }

    /**
     * Hace peticiones a un API endpoint 'login'. A traves de una URL.
     *
     * @param user Representa un objeto user.
     * @return true devuelve true si el usuario esta registrado en el sistema.
     */
    public boolean login(User user) {
        String URL = "http://localhost:8181/login";
        Response response;

        LoginRequest request = new LoginRequest(user.getUsername(), user.getPassword());

        Client client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target(URL);

        response = resourceTarget.request()
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));

        if (response.getStatus() == 200) {
            LoginResponse res = response.readEntity(LoginResponse.class);
            JSONObject jsonRes = new JSONObject(res);

            if (jsonRes.getInt("code") == 100) {
                return true;
            }
        }
        return false;
    }

    public void Register() {
        //Logica para registrar al usuario
    }

}
