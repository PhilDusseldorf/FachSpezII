package com.kladusch.app;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// Panels
	WarenList warenList;
    Prototyp startPanel;
    Sortiment sortPanel;
    Warenkorb warenPanel;
    Bestellung bestellPanel;
	
	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		this.setTitle("myCD-Shop");
		this.setResizable(false);
		
		// panel initializations
		warenList = new WarenList();
		startPanel = new Prototyp(this);
		sortPanel = new Sortiment(this);
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
}
