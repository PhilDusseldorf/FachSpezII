package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;

public class Sortiment extends MyPanel {
	private JPanel articleList;
	private JPanel centerPanel;
	private JPanel centerMenu;
	private JPanel categoryPanel;

	public Sortiment(MyFrame frame) {
		super(frame);
		
		// the center panel with upper centerMenu panel and the panel for the articleList
		centerPanel = new JPanel();
		this.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		// upper center panel with search and sort 
		centerMenu = new JPanel();
		centerMenu.setBounds(0, 0, 644, 82);
		centerPanel.add(centerMenu);
		centerMenu.setLayout(null);
		
		JLabel fastSearch = new JLabel("0-9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
		fastSearch.setHorizontalAlignment(SwingConstants.CENTER);
		fastSearch.setBounds(149, 11, 361, 14);
		centerMenu.add(fastSearch);
		
		JLabel lblSortiment = new JLabel("Sortiment");
		lblSortiment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSortiment.setBounds(10, 42, 85, 22);
		centerMenu.add(lblSortiment);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Albumtitel", "Interpret", "Preis"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(522, 42, 92, 22);
		centerMenu.add(comboBox);
		
		// here the sorted and/or searched articles are shown
		articleList = new JPanel();
		articleList.setLayout(new GridLayout(0, 5, 0, 0));
		
		// create dummy articles
		for (int i = 0; i < 20 ; i++) {
			articleList.add(createArtikel());
		}
		
		// scroll panel for articles
		JScrollPane scrollArt = new JScrollPane (articleList, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollArt.setBounds(0, 81, 620, 390);
		centerPanel.add(scrollArt);
		
		// the category panel
		categoryPanel = new JPanel();
		categoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		// header for categories
		JLabel lblKategorie = new JLabel("Kategorien");
		lblKategorie.setFont(new Font("Tahoma", Font.BOLD, 16));
		categoryPanel.add(lblKategorie);
		
		// scroll panel for categories
		JScrollPane scrollKat = new JScrollPane (categoryPanel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollKat, BorderLayout.WEST);
		
		createCategorieButtons(categoryPanel);
	}
	
	private void createCategorieButtons(JPanel panel) {
		// create dummy categories
		for (int i = 0; i < 25; i++) {
			String number = String.valueOf(i+1);
			if (i < 10) {
				number = "0"+number;
			}
			JButton btnKategorie = new JButton("Kategorie"+number);
			panel.add(btnKategorie);
		}	
	}


	private Artikel createArtikel () {
		return new Artikel(frame);
	}
}
