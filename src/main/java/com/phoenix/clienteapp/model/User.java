package com.phoenix.clienteapp.model;

public class User {

    private String name;
    private String lastname;
    private int yearold;
    private String username;
    private String password;
    private Auth auth;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String lastname, int yearold, String username, String password) {
        this.name = name;
        this.lastname = lastname;
        this.yearold = yearold;
        this.username = username;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearold() {
        return yearold;
    }

    public void setYearold(int yearold) {
        this.yearold = yearold;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", auth=" + auth + '}';
    }
}
