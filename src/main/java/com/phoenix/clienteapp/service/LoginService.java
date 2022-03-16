package com.phoenix.clienteapp.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Esta clase servlet servira como un proxy para validar de nueva cuenta el acceso a los recursos,
 */
@WebServlet("/showlogoservlet")
public class LoginService extends HttpServlet {

     public void doGet(HttpServletResponse res)  throws ServletException, IOException {
        res.setContentType("text/html");
        //res.sendRedirect("http://www.google.com");
       
    }
}
