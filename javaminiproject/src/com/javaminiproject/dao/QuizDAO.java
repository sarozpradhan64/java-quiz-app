package com.javaminiproject.dao;

import java.util.List;

import com.javaminiproject.model.Quiz;

public interface QuizDAO {
List<Quiz> get();
	
	Quiz get(int id);
	
	boolean save(Quiz quiz);
	
	boolean delete(int id);
	
	boolean update(Quiz  quiz);

}
