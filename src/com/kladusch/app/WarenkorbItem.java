package com.kladusch.app;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class WarenkorbItem extends JPanel implements ActionListener {
	private final int width = 470;
	private final int height = 40;
	
	private JLabel lblNameAlbum;
	private JLabel lblNameArtist;
	private JLabel lblSinglePrice;
	private JSpinner spinAmount;
	private JLabel lblSumPrice;
	private JButton btnRemove;
	
	// the values for the labels
	private String nameAlbum = "Albumtitel";
	private String nameArtist = "Interpret";
	private Double singlePrice = 7.99;
	private int  amount = 1;
	private Double sumPrice;

	public WarenkorbItem() {
		this.setSize(width, height);
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		sumPrice = singlePrice * amount;
		setLayout(new GridLayout(0, 6, 0, 0));
		
		lblNameAlbum = new JLabel(nameAlbum);
		lblNameAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameAlbum);
		
		lblNameArtist = new JLabel(nameArtist);
		lblNameArtist.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameArtist);
		
		lblSinglePrice = new JLabel(String.valueOf(singlePrice));
		lblSinglePrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSinglePrice);
		
		spinAmount = new JSpinner();
		spinAmount.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinAmount.setValue(Integer.valueOf(amount));
		add(spinAmount);
		
		lblSumPrice = new JLabel(String.valueOf(sumPrice));
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
