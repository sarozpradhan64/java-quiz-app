package com.javaminiproject.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaminiproject.model.Quiz;
import com.javaminiproject.util.DBConnection;

public class QuizDAOImpl implements QuizDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<Quiz> get() {
		List<Quiz> list = null;
		Quiz quiz = null;
		
		try {
			
			list = new ArrayList<Quiz>();
			String sql = "SELECT * FROM questions";
			connection = DBConnection.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				quiz = new Quiz();
				quiz.setId(resultSet.getInt("id"));
				quiz.setQuestion(resultSet.getString("question"));
				quiz.setOpt1(resultSet.getString("opt1"));
				quiz.setOpt2(resultSet.getString("opt2"));				
				quiz.setOpt3(resultSet.getString("opt3"));
				quiz.setOpt4(resultSet.getString("opt4"));
				quiz.setCorrect(resultSet.getString("correct"));
				list.add(quiz);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Quiz get(int id) {
		
		Quiz quiz = null;
		try {
			quiz = new Quiz();
			String sql = "SELECT * FROM questions where id="+id;
			connection = DBConnection.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				quiz.setId(resultSet.getInt("id"));
				quiz.setQuestion(resultSet.getString("question"));
				quiz.setOpt1(resultSet.getString("opt1"));
				quiz.setOpt2(resultSet.getString("opt2"));				
				quiz.setOpt3(resultSet.getString("opt3"));
				quiz.setOpt4(resultSet.getString("opt4"));
				quiz.setCorrect(resultSet.getString("correct"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return quiz;
	}
		
		
		
		
		
		
	

	@Override
	public boolean save(Quiz quiz) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO questions(question, opt1, opt2, opt3, opt4, correct)VALUES"
					+ "('"+quiz.getQuestion()+"', '"+quiz.getOpt1()+"', '"+quiz.getOpt2()+"', '"+quiz.getOpt3()+"', '"+quiz.getOpt4()+"', '"+quiz.getCorrect()+"')";
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM questions where id="+id;
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Quiz quiz) {
		boolean flag = false;
		try {
			String sql = "UPDATE questions SET question = '"+quiz.getQuestion()+"', opt1 =  '"+quiz.getOpt1()+"', opt2 = '"+quiz.getOpt2()+"', opt3 = '"+quiz.getOpt3()+"', opt4 = '"+quiz.getOpt4()+"', corrrect = '"+quiz.getCorrect()+"' where id="+quiz.getId();
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
