package com.kladusch.app;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WarenList extends JPanel {
	public WarenList() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
	}

	public void loadWarenkorbItems() {
		// creates dummy items
		for (int i = 0; i < 2; i++) {
			this.add(new WarenkorbItem());
		}
	}
}