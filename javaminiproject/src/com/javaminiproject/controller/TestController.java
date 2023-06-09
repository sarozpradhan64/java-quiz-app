package com.javaminiproject.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaminiproject.dao.QuizDAO;
import com.javaminiproject.dao.QuizDAOImpl;
import com.javaminiproject.model.Quiz;


@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RequestDispatcher dispatcher = null;
	QuizDAO quizdao = null;
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;

	
  
    public TestController() {
        quizdao = new QuizDAOImpl();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String action = request.getParameter("action");
	
	if(action == null) {
		action = "LIST";
	}
	
	switch(action) {
	
	case "LIST":
		listQuizz(request, response);
		break;
		
	case "answer":
		getSingleQuiz(request, response);
		break;
		
	
		
	default:
		listQuizz(request, response);
		break;
		
}
    }

	
	protected void listQuizz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Quiz> theList = quizdao.get();
		String student = request.getParameter("student");
		
		request.setAttribute("list", theList);
		request.setAttribute("student", "Welcome " + student);
		
		dispatcher = request.getRequestDispatcher("/views/Test.jsp");
		
		dispatcher.forward(request, response);
	
	}

	private void getSingleQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Quiz thequiz = quizdao.get(Integer.parseInt(id));
		
		request.setAttribute("quiz", thequiz);
		
		dispatcher = request.getRequestDispatcher("/views/answer-form.jsp");
		
		dispatcher.forward(request, response);
	}	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter("light");
		String correct = request.getParameter("correct");
		if(answer != null) {
		
		if(answer.equals(correct)) {

				
					request.setAttribute("NOTIFICATION", "correct answer!");
					
					
					getSingleQuiz(request, response);
					}
				
					else {
						request.setAttribute("NOTIFICATION", "Wrong, " + correct + "is correct answer!");
					
					}
					
													
								getSingleQuiz(request, response);
											}
											
											
								
										

else {
	request.setAttribute("NOTIFICATION", " Please Select one");
	getSingleQuiz(request, response);
	
	
}
	}}							

	
		
		


