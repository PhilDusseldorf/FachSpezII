package com.kladusch.app.model.crud;

import java.sql.ResultSet;

import com.kladusch.app.model.interfaces.DBConnection;

public class WebDBConnection implements DBConnection{

	@Override
	public ResultSet getDataFromDB(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStringToDB(String query, String content1, int content2) {
		// TODO Auto-generated method stub
		
	}
}
