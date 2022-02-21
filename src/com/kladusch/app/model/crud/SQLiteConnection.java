package com.kladusch.app.model.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kladusch.app.model.interfaces.DBConnection;

public class SQLiteConnection implements DBConnection {
	// ATTRIBUTES
	private static final String URL = "jdbc:sqlite:./db.db";
	private Connection connection;
	
	// CONSTRUCTORS
	public SQLiteConnection () {
		try {
			this.connection = DriverManager.getConnection(URL);
			System.out.println("Connection established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// METHODS
	@Override
	public ResultSet getDataFromDB(String query) {
		Statement statement;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public void insertStringToDB(String query, String content1, int content2) {
		System.out.println("FileName: " + content2);
		try {
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, content1);
			preparedStmt.setInt (2, content2);
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
