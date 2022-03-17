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

    private int user_id;
    private int auth_id;
    private String username;
    private String password;
    private String token;

    public Auth() {
    }

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Auth(int user_id, int auth_id, String username, String password) {
        this.user_id = user_id;
        this.auth_id = auth_id;
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(int auth_id) {
        this.auth_id = auth_id;
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
