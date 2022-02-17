package com.kladusch.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.MyFrame;

public class TopMenu extends JPanel implements ActionListener {
	MyFrame frame;
	JLabel storeName;
	JButton btnSortiment;
	JButton btnWarenkorb;
	JButton btnSearch;
	JTextField searchField;
	
	
	public TopMenu (MyFrame frame) {
		this.frame = frame;
		this.setBackground(Color.DARK_GRAY);
		this.setBorder(new EmptyBorder(10, 10, 10, 10));

		createItems();
	}
	
	private void createItems() {
		storeName = new JLabel("MyCD-Store");
		storeName.setForeground(Color.white);
		storeName.setHorizontalAlignment(SwingConstants.LEFT);
		storeName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(storeName);
		
		btnSortiment = new JButton("Sortiment");
		btnSortiment.addActionListener(this);
		this.add(btnSortiment);
		
		btnWarenkorb = new JButton("Warenkorb");
		btnWarenkorb.addActionListener(this);
		this.add(btnWarenkorb);
		
		searchField = new JTextField();
		searchField.setText("");
		searchField.setColumns(10);
		this.add(searchField);
		
		btnSearch = new JButton("Suche");
		btnSearch.addActionListener(this);
		this.add(btnSearch);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == btnSortiment){
	            System.out.println("Button Sortiment geklickt!");
	            frame.startSearch("");
	        }
		 
		 if(e.getSource() == btnWarenkorb){
	            System.out.println("Button Warenkorb geklickt!");
	            frame.getWarenList().loadWarenkorbItems();
	            ((Warenkorb)frame.getWarenPanel()).refreshZuZahlen();
	            frame.changePanel(frame.getWarenPanel());
	        }
		 
		 if(e.getSource() == btnSearch){
	            System.out.println("Search text: " + searchField.getText());
	            frame.startSearch(searchField.getText());
	        }
	}
	
}
