package com.javaminiproject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javaminiproject.model.Login;
import com.javaminiproject.util.DBConnection;
import java.sql.Connection;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public String authencate(Login login) {
		String sql = "select * from admin where email=? and password =?";
	
	try {
		Connection connection =  DBConnection.openConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, login.getEmail());
		ps.setString(2, login.getPassword());
		ResultSet rs = ps.executeQuery();
	
	if(rs.next()) {
		return "true";
		
	}
	else {
		return "false";
	}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return "error";
	}
	
	
	
	
	}


