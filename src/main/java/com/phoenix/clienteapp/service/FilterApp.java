package com.phoenix.clienteapp.service;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * req
 *
 * @author daniel
 */
//@WebFilter("/app/*")
public class FilterApp implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();

        System.out.println(request.getRequestURI().toString());
        if (session.getAttribute("sesion") == null) {
            System.out.println("Sesion setteada por jsf: " + session.getAttribute("sesion"));
            //String page = request.getContextPath() + "/app/home.xhtml";
//           response.sendRedirect(page); // No logged-in user found, so redirect to login page.
            response.sendRedirect(request.getContextPath() + "/index.xhtml"); // No logged-in user found, so redirect to login page.
            return;
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }
}
