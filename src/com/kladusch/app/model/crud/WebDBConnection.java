package com.kladusch.app.model.crud;

import com.kladusch.app.model.interfaces.DBConnection;

public class WebDBConnection implements DBConnection{

	@Override
	public String getDataFromDB() {
		return "Data from WebDB";
	}

}
