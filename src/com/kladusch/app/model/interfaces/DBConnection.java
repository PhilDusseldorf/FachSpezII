package com.kladusch.app.model.interfaces;

import java.sql.ResultSet;

public interface DBConnection {
	ResultSet getDataFromDB(String query);
	void insertStringToDB(String query, String content1, int content2);
}
