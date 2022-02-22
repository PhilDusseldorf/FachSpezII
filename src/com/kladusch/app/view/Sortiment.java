package com.kladusch.app.view;

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

import com.kladusch.app.MyFrame;
import com.kladusch.app.MyPanel;
import com.kladusch.app.model.KatalogItem;
import com.kladusch.app.model.MainModel;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class Sortiment extends MyPanel implements ActionListener {
	
	private JPanel articleListPanel;
	private JPanel centerPanel;
	private JPanel centerMenu;
	private JPanel categoryPanel;
	private JComboBox<String> comboBox;
	private List<KatalogItem> katalog;
	private List<KatalogItem> searchItemList;

	public Sortiment(MyFrame frame) {
		super(frame);

		this.katalog = model.getKatalog();
		this.searchItemList = new ArrayList<>(katalog);
		
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
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Albumtitel", "Interpret", "Preis"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(422, 42, 92, 22);
		centerMenu.add(comboBox);
		
		// here the sorted and/or searched articles are shown
		articleListPanel = new JPanel();
		articleListPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		addItemsToArtikelListPanel();
		
		// scroll panel for articles
		JScrollPane scrollArt = new JScrollPane (articleListPanel, 
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
		
		createCategorieButtons(categoryPanel, model.getKategorien());
	}
	
	private void addItemsToArtikelListPanel() {
		articleListPanel.removeAll();
		for (KatalogItem item:  searchItemList) {
			articleListPanel.add(new Artikel(frame, item, model));
		}
	}

	private void createCategorieButtons(JPanel panel, List<String> kategorien) {
		
		for (String str : kategorien) {
			JButton btnKategorie = new JButton(str);
			btnKategorie.addActionListener(this);
			panel.add(btnKategorie);
		}	
	}
	
	private void showSortedList() {
		sortList(comboBox.getSelectedItem().toString());
		addItemsToArtikelListPanel();
		frame.changePanel((MyPanel)frame.getSortPanel());
	}
	
	public void showSearch(String text) {
		searchItemList.clear();
		for (KatalogItem item: katalog) {
			if (item.nameAlbum.toLowerCase().contains(text.toLowerCase()) || item.nameArtist.toLowerCase().contains(text.toLowerCase())) {
				searchItemList.add(item);
			}
		}
		showSortedList();
	}
	
	private void showCategorie(String text) {
		searchItemList.clear();
		for (KatalogItem item: katalog) {
			for (String kat : item.kategorienList) {
				if (kat.toLowerCase().contains(text.toLowerCase())) {
					searchItemList.add(item);	
				}
			}
		}
		showSortedList();
	}
	
	private void sortList(String criteria) {
		switch(criteria) {
		case "Albumtitel":
			searchItemList.sort((o1, o2) -> o1.nameAlbum.compareTo(o2.nameAlbum));
			break;
		case "Interpret":
			searchItemList.sort((o1, o2) -> o1.nameArtist.compareTo(o2.nameArtist));
			break;
		case "Preis":
			searchItemList.sort((o1, o2) -> o1.price.compareTo(o2.price));
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			showCategorie(e.getActionCommand());
		}
	}
}
