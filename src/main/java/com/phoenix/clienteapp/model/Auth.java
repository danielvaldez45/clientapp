package com.phoenix.clienteapp.model;

/**
 *
 * @author daniel
 */
/**
 * Entidad para guardar en memoria la identidad del usuario. Con esta entidad
 * puedo hacer peticiones al backend
 */
public class Auth {

    private int id;
    private String username;
    private String password;
    private String token;

    public Auth() {
    }

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Auth(int id, String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Auth{" + "username=" + username + ", password=" + password + ", token=" + token + '}';
    }
}
