package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Warenkorb extends MyPanel implements ActionListener {

	public Warenkorb(MyFrame frame) {
		super(frame);
		
		JPanel warenkorbPanel = new JPanel();
		this.add(warenkorbPanel, BorderLayout.CENTER);
		warenkorbPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Warenkorb");
		lblNewLabel_1.setBounds(319, 0, 85, 22);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		warenkorbPanel.add(lblNewLabel_1);
		
		JScrollPane warenkorbScroll = new JScrollPane();
		warenkorbScroll.setBounds(68, 33, 609, 354);
		warenkorbScroll.setViewportBorder(new EmptyBorder(50, 50, 50, 50));
		warenkorbScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		warenkorbScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		warenkorbPanel.add(warenkorbScroll);
		
		JLabel lblNewLabel_2 = new JLabel("Gesamt zu Zahlen:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(457, 398, 142, 22);
		warenkorbPanel.add(lblNewLabel_2);
		
		JLabel sumLabel = new JLabel("89,89 \u20AC");
		sumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sumLabel.setBounds(609, 398, 50, 19);
		warenkorbPanel.add(sumLabel);
		
		JButton btnBezahlen = new JButton("Bezahlvorgang starten");
		btnBezahlen.setBackground(new Color(0, 128, 0));
		btnBezahlen.addActionListener(this);
		btnBezahlen.setBounds(573, 423, 104, 40);
		warenkorbPanel.add(btnBezahlen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Bezahlvorgang startet...");	
		frame.changePanel(frame.bestellPanel);
	}
}
