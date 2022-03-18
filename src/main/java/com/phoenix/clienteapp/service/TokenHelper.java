package com.phoenix.clienteapp.service;

import com.phoenix.clienteapp.model.Token;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel
 */
public class TokenHelper {
    /*
    public void setToken(String name, String value, int expiry) {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Token token = null;

        HttpSession session = request.getSession();

        if (session != null) {
            session.setAttribute("token", token);
        } else {
            cookie = new Cookie(name, value);
            cookie.setPath(request.getContextPath());
        }

        

        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addHeader(value, value);
    }

    public Cookie getCookie(String name) {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(name)) {
                    cookie = userCookies[i];
                    return cookie;
                }
            }
        }
        return null;
    }
     */
}
