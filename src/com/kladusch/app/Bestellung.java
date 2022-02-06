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
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.DropMode;

public class Bestellung extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bestellung frame = new Bestellung();
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
	public Bestellung() {
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
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		topMenu.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sortiment");
		topMenu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Warenkorb");
		topMenu.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setText("Search");
		textField.setColumns(10);
		topMenu.add(textField);
		
		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(dataPanel, BorderLayout.WEST);
		dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_3 = new JLabel("Kundendaten");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		dataPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Vorname");
		dataPanel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		dataPanel.add(textField_1);
		textField_1.setColumns(1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nachname");
		dataPanel.add(lblNewLabel_4_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(1);
		dataPanel.add(textField_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Strasse");
		dataPanel.add(lblNewLabel_4_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(1);
		dataPanel.add(textField_3);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Hausnummer");
		lblNewLabel_4_1_2.setVerticalAlignment(SwingConstants.TOP);
		dataPanel.add(lblNewLabel_4_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(1);
		dataPanel.add(textField_4);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("Stadt");
		dataPanel.add(lblNewLabel_4_1_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(1);
		dataPanel.add(textField_5);
		
		JLabel lblNewLabel_4_1_3_1 = new JLabel("PLZ");
		dataPanel.add(lblNewLabel_4_1_3_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(1);
		dataPanel.add(textField_6);
		
		JPanel bestellPanel = new JPanel();
		bestellPanel.setLayout(null);
		contentPane.add(bestellPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Bestellung");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(73, 0, 85, 22);
		bestellPanel.add(lblNewLabel_1);
		
		JScrollPane warenkorbItems = new JScrollPane();
		warenkorbItems.setViewportBorder(new EmptyBorder(50, 50, 50, 50));
		warenkorbItems.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		warenkorbItems.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		warenkorbItems.setBounds(50, 33, 390, 232);
		bestellPanel.add(warenkorbItems);
		
		JLabel lblNewLabel_2 = new JLabel("Gesamt zu Zahlen:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(238, 396, 142, 22);
		bestellPanel.add(lblNewLabel_2);
		
		JLabel sumLabel = new JLabel("89,89 \u20AC");
		sumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sumLabel.setBounds(390, 398, 50, 19);
		bestellPanel.add(sumLabel);
		
		JButton btnNewButton_2 = new JButton("Bezahlvorgang starten");
		btnNewButton_2.setBackground(new Color(0, 128, 0));
		btnNewButton_2.setBounds(348, 423, 104, 40);
		bestellPanel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Zur\u00FCck zum Warenkorb");
		btnNewButton_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1.setBounds(221, 423, 104, 40);
		bestellPanel.add(btnNewButton_2_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("auf Rechnung");
		rdbtnNewRadioButton.setBounds(73, 272, 109, 23);
		bestellPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("per Nachnahme");
		rdbtnNewRadioButton_1.setBounds(73, 298, 109, 23);
		bestellPanel.add(rdbtnNewRadioButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ich stimme den AGB zu.");
		chckbxNewCheckBox.setBounds(224, 298, 170, 23);
		bestellPanel.add(chckbxNewCheckBox);
		
		
	}
}
