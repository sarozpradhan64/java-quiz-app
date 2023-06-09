package com.javaminiproject.controller;

import java.io.IOException;
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


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	QuizDAO quizdao = null;
	
    
    public Controller() {
        quizdao = new QuizDAOImpl();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
		
		case "LIST":
			listQuiz(request, response);
			break;
			
		case "EDIT":
			getSingleQuiz(request, response);
			break;
			
		case "DELETE":
			deleteQuiz(request, response);
			break;
			
		default:
			listQuiz(request, response);
			break;
			
	}
	
}

private void deleteQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String id = request.getParameter("id");

	if(quizdao.delete(Integer.parseInt(id))) {
		request.setAttribute("NOTIFICATION", "Question Deleted Successfully!");
	}
	
	listQuiz(request, response);
}
		
private void getSingleQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	String id = request.getParameter("id");
	
	Quiz thequiz = quizdao.get(Integer.parseInt(id));
	
	request.setAttribute("quiz", thequiz);
	
	dispatcher = request.getRequestDispatcher("/views/quiz-form.jsp");
	
	dispatcher.forward(request, response);
}	



		
private void listQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<Quiz> theList = quizdao.get();
	
	request.setAttribute("list", theList);
	
	dispatcher = request.getRequestDispatcher("/views/quiz-list.jsp");
	
	dispatcher.forward(request, response);
}
		
		


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	String id = request.getParameter("id");
	Quiz quiz = new Quiz();
	//getting error heree.... quiz.setId(Integer.parseInt(id));
	quiz.setQuestion(request.getParameter("question"));
	quiz.setOpt1(request.getParameter("opt1"));
	quiz.setOpt2(request.getParameter("opt2"));
	quiz.setOpt3(request.getParameter("opt3"));
	quiz.setOpt4(request.getParameter("opt4"));
	quiz.setCorrect(request.getParameter("correct"));
	
	if(id.isEmpty() || id == null) {
		
		if(quizdao.save(quiz)) {
			request.setAttribute("NOTIFICATION", "Question Saved Successfully!");
		}
	
	}else {
		
		quiz.setId(Integer.parseInt(id));
		if(quizdao.update(quiz)) {
			request.setAttribute("NOTIFICATION", "Question Updated Successfully!");
		}
		
	}
	
	listQuiz(request, response);
}

}
		
		
		

    