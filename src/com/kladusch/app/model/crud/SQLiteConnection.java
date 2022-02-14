package com.kladusch.app.model.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kladusch.app.model.interfaces.DBConnection;

public class SQLiteConnection implements DBConnection {
	// ATTRIBUTES
	private static final String URL = "jdbc:sqlite:./preparation/db.db";
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
	public String getDataFromDB() {
		return "data from sqlliteDB";
	}

}
