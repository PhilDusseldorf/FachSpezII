package com.kladusch.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kladusch.app.model.interfaces.DBConnection;

public class MainModel {
	// ATTRIBUTES
	private DBConnection connection;
	private List<KatalogItem> katalog = new ArrayList<>();
	private List<String> kategorien = new ArrayList<>();
	
	// GETTERS & SETTERS
	public DBConnection getDBConnection() {
		return connection;
	}
	
	public void setDBConnection(DBConnection con) {
		this.connection = con;
	}
	
	public List<KatalogItem> getKatalog() {
		return katalog;
	}
	
	public List<String> getKategorien() {
		return kategorien;
	}
	
	// CONSTRUCTORS
	public MainModel(DBConnection con) {
		this.setDBConnection(con);
		
		createKatalog();
		createKategorien();
	}
	
	// METHODS
	public ResultSet getData(String query) {
		return this.getDBConnection().getDataFromDB(query);
	}
	
	private void createKatalog() {
		// TODO: creates the katalog but does not get icon or categories from database yet
		
		String query = "SELECT artikel.id, artikel.name AS album, interpret.name AS artist, beschreibung, preis FROM artikel "
				+ "JOIN artikelinterpret ON artikel.id = artikelinterpret.a_id "
				+ "JOIN interpret ON interpret.id = artikelinterpret.i_id "
				+ "ORDER BY artikel.id;"
				;
		ResultSet rs = getData(query);
		
		// Test if result set gets results:
		try {
			while (rs.next()) {
				KatalogItem item = new KatalogItem(
						rs.getInt("id"),
					    rs.getString("album"),
					    rs.getString("artist"),
					    rs.getString("beschreibung"),
					    rs.getDouble("preis")
					    );
				katalog.add(item);	// adds the katItem, the katalog-index is its id
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("katalog items: " + katalog.size());
	}
	
	private void createKategorien() {		
		String query = "SELECT bezeichnung FROM kategorie;";
		ResultSet rs = getData(query);
		
		// Test if result set gets results:
		try {
			while (rs.next()) {
				kategorien.add(rs.getString("bezeichnung"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("kategorien items: " + katalog.size());
	}

}
