package com.kladusch.app;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// Panels
    Prototyp startPanel;
    Sortiment sortPanel;
    Warenkorb warenPanel;
	
	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		this.setTitle("myCD-Shop");
		this.setResizable(false);
		
		// panel initializations
		startPanel = new Prototyp(this);
		sortPanel = new Sortiment(this);
		warenPanel = new Warenkorb(this);
		
		changePanel(startPanel);
	}
	
    public void changePanel(MyPanel newPanel) {
    	System.out.println("Content Pane before: " + this.getContentPane().getClass().getSimpleName());

    	this.setContentPane(newPanel);

    	this.setVisible(true);
    	System.out.println("Content Pane after: " + this.getContentPane().getClass().getSimpleName());
    }
}