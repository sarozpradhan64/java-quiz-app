package com.javaminiproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaminiproject.dao.LoginDAO;
import com.javaminiproject.dao.LoginDAOImpl;
import com.javaminiproject.model.Login;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	LoginDAO logindao = null;
   
    public LoginController() {
logindao = new LoginDAOImpl();

        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login login = new Login();
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		
String status =		logindao.authencate(login);
		if(status.equals("true")) {
			response.sendRedirect("Controller?action=LIST");
		}
		
		if(status.equals("false")) {
			response.sendRedirect("views/login.jsp?status=false");
		}

		if(status.equals("error")) {
			response.sendRedirect("views/login.jsp?status=error");
		}
		

		
	}

}
