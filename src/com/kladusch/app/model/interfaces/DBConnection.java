package com.kladusch.app.model.interfaces;

import java.sql.ResultSet;

public interface DBConnection {
	ResultSet getDataFromDB(String query);
}
