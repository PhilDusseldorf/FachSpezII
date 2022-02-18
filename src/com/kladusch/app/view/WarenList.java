package com.kladusch.app.view;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.MyFrame;
import com.kladusch.app.model.BuyItem;
import com.kladusch.app.model.MainModel;

public class WarenList extends JPanel {
	MyFrame frame;
	
	public WarenList(MyFrame frame) {
		this.frame = frame;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));
	}

	public void loadWarenkorbItems() {
		this.removeAll();
		List<BuyItem> buyList = frame.getMainModel().getBuyList();
		for (BuyItem item : buyList) {
			System.out.println("adding an item");
			this.add(new WarenkorbItem(item, frame));
		}
	}
	
	public void loadBestellung() {
		this.removeAll();
		List<BuyItem> buyList = frame.getMainModel().getBuyList();
		for (BuyItem item : buyList) {
			System.out.println("adding an bestellungs item");
			this.add(new BestellItem(item, frame));
		}
	}
}