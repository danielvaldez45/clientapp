package com.phoenix.clienteapp.http;

import com.phoenix.clienteapp.model.User;

/**
 *
 * @author daniel
 */
public class RegisterRequest {

    private User user;

    public RegisterRequest(User User) {
        this.user = User;
    }
}
