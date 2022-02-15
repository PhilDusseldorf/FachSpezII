package com.kladusch.app.model.crud;

import java.sql.Connection;
import java.sql.DriverManager;
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

}
