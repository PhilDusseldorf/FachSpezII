package com.kladusch.app.view;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.model.BuyItem;

import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class WarenkorbItem extends JPanel implements ActionListener {
	private final int width = 470;
	private final int height = 40;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance(getDefaultLocale());
	
	private JLabel lblNameAlbum;
	private JLabel lblNameArtist;
	private JLabel lblSinglePrice;
	private JSpinner spinAmount;
	private JLabel lblSumPrice;
	private JButton btnRemove;
	
	// the values for the labels
	private String nameAlbum;
	private String nameArtist;
	private double singlePrice;
	private int  amount = 1;
	private double sumPrice;
	
	public double getSumPrice() {
		return sumPrice;
	}

	public WarenkorbItem(BuyItem item) {
		this.setSize(width, height);
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.amount = item.getAmount();
		
		singlePrice = item.getPrice();
		
		sumPrice = singlePrice * amount;
		setLayout(new GridLayout(0, 6, 0, 0));
		
		lblNameAlbum = new JLabel(item.getAlbum());
		lblNameAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameAlbum);
		
		lblNameArtist = new JLabel(item.getArtist());
		lblNameArtist.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameArtist);
		
		lblSinglePrice = new JLabel(formatter.format(singlePrice));
		lblSinglePrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSinglePrice);
		
		spinAmount = new JSpinner();
		spinAmount.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinAmount.setValue(Integer.valueOf(amount));
		add(spinAmount);
		
		lblSumPrice = new JLabel(formatter.format(sumPrice));
		lblSumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSumPrice);
		
		btnRemove = new JButton("X");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnRemove.addActionListener(this);
		add(btnRemove);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRemove ) {
			System.out.println("Item soll entfernt werden.");
		}
		
	}
}
