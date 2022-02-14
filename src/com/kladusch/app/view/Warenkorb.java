package com.kladusch.app.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.MyFrame;
import com.kladusch.app.MyPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

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
	JPanel warenkorbPanel;
	WarenList warenList;
	JScrollPane warenkorbScroll;
	
	JLabel lblWarenkorb;
	JLabel lblZuZahlen;
	JLabel sumLabel;
	
	JButton btnBezahlen;

	public Warenkorb(MyFrame frame) {
		super(frame);
		
		warenkorbPanel = new JPanel();
		this.add(warenkorbPanel, BorderLayout.CENTER);
		warenkorbPanel.setLayout(null);
		
		lblWarenkorb = new JLabel("Warenkorb");
		lblWarenkorb.setBounds(319, 0, 85, 22);
		lblWarenkorb.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarenkorb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		warenkorbPanel.add(lblWarenkorb);
		
		// here the warenkorbItems are shown
		warenList = new WarenList();
		warenList.loadWarenkorbItems();
		
		warenkorbScroll = new JScrollPane(warenList, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		warenkorbScroll.setBounds(68, 33, 609, 354);
		warenkorbPanel.add(warenkorbScroll);
		
		lblZuZahlen = new JLabel("Gesamt zu Zahlen:");
		lblZuZahlen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZuZahlen.setBounds(457, 398, 142, 22);
		warenkorbPanel.add(lblZuZahlen);
		
		sumLabel = new JLabel("89,89 \u20AC");
		sumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sumLabel.setBounds(609, 398, 50, 19);
		warenkorbPanel.add(sumLabel);
		
		btnBezahlen = new JButton("Bezahlvorgang starten");
		btnBezahlen.setBackground(new Color(0, 128, 0));
		btnBezahlen.addActionListener(this);
		btnBezahlen.setBounds(573, 423, 104, 40);
		warenkorbPanel.add(btnBezahlen);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Bezahlvorgang startet...");	
		frame.changePanel(frame.getBestellPanel());
	}
}
