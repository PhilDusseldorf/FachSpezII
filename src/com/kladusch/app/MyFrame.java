package com.kladusch.app;

import java.util.List;

import javax.swing.JFrame;

import com.kladusch.app.model.KatalogItem;
import com.kladusch.app.view.Bestellung;
import com.kladusch.app.view.Prototyp;
import com.kladusch.app.view.Sortiment;
import com.kladusch.app.view.WarenList;
import com.kladusch.app.view.Warenkorb;

public class MyFrame extends JFrame {
	// Panels
	private WarenList warenList;
    private MyPanel startPanel;
    private MyPanel sortPanel;
    private MyPanel warenPanel;
    private MyPanel bestellPanel;

	public WarenList getWarenList() {
		return warenList;
	}

	public MyPanel getStartPanel() {
		return startPanel;
	}

	public MyPanel getSortPanel() {
		return sortPanel;
	}

	public MyPanel getWarenPanel() {
		return warenPanel;
	}

	public MyPanel getBestellPanel() {
		return bestellPanel;
	}

	public MyFrame(List<KatalogItem> katalog, List<String> kategorien) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		this.setTitle("myCD-Shop");
		this.setResizable(false);
		
		// panel initializations
		warenList = new WarenList();
		startPanel = new Prototyp(this);
		sortPanel = new Sortiment(this, katalog, kategorien);
		warenPanel = new Warenkorb(this);
		bestellPanel = new Bestellung(this);
		
		changePanel(startPanel);
	}
	
    public void changePanel(MyPanel newPanel) {
    	System.out.println("Content Pane before: " + this.getContentPane().getClass().getSimpleName());

    	this.setContentPane(newPanel);

    	this.setVisible(true);
    	System.out.println("Content Pane after: " + this.getContentPane().getClass().getSimpleName());
    }

	public void startSearch(String text) {
		((Sortiment)sortPanel).showSearch(text);
	}
}
