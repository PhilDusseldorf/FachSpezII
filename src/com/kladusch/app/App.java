package com.kladusch.app;

import javax.swing.UIManager;

import com.kladusch.app.model.MainModel;
import com.kladusch.app.model.crud.SQLiteConnection;
import com.kladusch.app.model.interfaces.DBConnection;

public class App {
	
    public static void main(String[] args) throws Exception {
    	// set up Database
    	DBConnection connection = new SQLiteConnection();
    	MainModel model = new MainModel(connection);
    	// Frame
    	MyFrame frame = new MyFrame(model.getKatalog());
        
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
