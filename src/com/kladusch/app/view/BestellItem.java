package com.kladusch.app.view;

import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import com.kladusch.app.MyFrame;
import com.kladusch.app.model.BuyItem;

public class BestellItem extends JPanel {
	private final int width = 470;
	private final int height = 40;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance(getDefaultLocale());
	
	private MyFrame frame;
	
	private JLabel lblAmount;
	private JLabel lblNameAlbum;
	private JLabel lblNameArtist;
	private JLabel lblSinglePrice;
	private JLabel lblSumPrice;
	
	private double singlePrice;
	private int amount;
	private double sumPrice;
	
	public BestellItem(BuyItem item, MyFrame frame) {
		this.setSize(width, height);
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.frame = frame;
		this.amount = item.getAmount();
		singlePrice = item.getPrice();
		System.out.println("all is well");
		sumPrice = singlePrice * amount;
		setLayout(new GridLayout(0, 6, 0, 0));
		
		lblAmount = new JLabel(String.valueOf(amount) + "x");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAmount);
		System.out.println("still well");
		lblNameAlbum = new JLabel(item.getAlbum());
		lblNameAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameAlbum);
		
		lblNameArtist = new JLabel(item.getArtist());
		lblNameArtist.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameArtist);
		
		lblSinglePrice = new JLabel(formatter.format(singlePrice));
		lblSinglePrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSinglePrice);
		
		lblSumPrice = new JLabel(formatter.format(sumPrice));
		lblSumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSumPrice);
	}
}
