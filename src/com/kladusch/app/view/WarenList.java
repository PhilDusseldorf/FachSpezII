package com.kladusch.app.view;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.model.BuyItem;
import com.kladusch.app.model.MainModel;

public class WarenList extends JPanel {
	public WarenList() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
	}

	public void loadWarenkorbItems() {
		this.removeAll();
		List<BuyItem> buyList = MainModel.buyList;
		for (BuyItem item : buyList) {
			System.out.println("adding an item");
			this.add(new WarenkorbItem(item));
		}
	}
}