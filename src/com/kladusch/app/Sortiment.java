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

public class Sortiment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSortBy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sortiment frame = new Sortiment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sortiment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topMenu = new JPanel();
		topMenu.setBackground(Color.WHITE);
		topMenu.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(topMenu, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("MyCD-Store");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		topMenu.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sortiment");
		topMenu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Warenkorb");
		topMenu.add(btnNewButton_1);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		topMenu.add(txtSearch);
		
		textField = new JTextField();
		textField.setText("Search");
		textField.setColumns(10);
		topMenu.add(textField);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		JPanel centerMenu = new JPanel();
		centerMenu.setBounds(0, 0, 644, 82);
		centerPanel.add(centerMenu);
		centerMenu.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("0-9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(149, 11, 361, 14);
		centerMenu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sortiment");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 42, 85, 22);
		centerMenu.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(590, 45, 30, 22);
		centerMenu.add(comboBox);
		
		txtSortBy = new JTextField();
		txtSortBy.setText("sort by");
		txtSortBy.setBounds(534, 46, 86, 20);
		centerMenu.add(txtSortBy);
		txtSortBy.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 82, 644, 403);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		centerPanel.add(scrollPane);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(categoryPanel, BorderLayout.WEST);
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Kategorien");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		categoryPanel.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Kategorie 03");
		categoryPanel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_1_1 = new JButton("Kategorie 03");
		categoryPanel.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_2_1 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2_2_1);
		
		JButton btnNewButton_2_4 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2_4);
		
		JButton btnNewButton_2_1_2 = new JButton("Kategorie 03");
		categoryPanel.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_2_2_2 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2_2_2);
		
		JButton btnNewButton_2_3_1 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Kategorie 03");
		categoryPanel.add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_2_1_1 = new JButton("Kategorie 01");
		categoryPanel.add(btnNewButton_2_2_1_1);
		txtSearch.setColumns(10);

}

