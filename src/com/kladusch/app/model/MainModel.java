package com.kladusch.app.model;

import com.kladusch.app.model.interfaces.DBConnection;

public class MainModel {
	private DBConnection dbConnection;
	
	public DBConnection getDBConnection() {
		return dbConnection;
	}
	
	public void setDBConnection(DBConnection con) {
		this.dbConnection = con;
	}
	
	public MainModel(DBConnection con) {
		this.setDBConnection(null);
	}
	
	public String getData() {
		return this.getDBConnection().getDataFromDB();
	}

}
