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

public class Warenkorb extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warenkorb frame = new Warenkorb();
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
	public Warenkorb() {
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
		
		JPanel warenkorbPanel = new JPanel();
		contentPane.add(warenkorbPanel, BorderLayout.CENTER);
		warenkorbPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Warenkorb");
		lblNewLabel_1.setBounds(319, 0, 85, 22);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		warenkorbPanel.add(lblNewLabel_1);
		
		JScrollPane warenkorbItems = new JScrollPane();
		warenkorbItems.setBounds(68, 33, 609, 354);
		warenkorbItems.setViewportBorder(new EmptyBorder(50, 50, 50, 50));
		warenkorbItems.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		warenkorbItems.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		warenkorbPanel.add(warenkorbItems);
		
		JLabel lblNewLabel_2 = new JLabel("Gesamt zu Zahlen:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(457, 398, 142, 22);
		warenkorbPanel.add(lblNewLabel_2);
		
		JLabel sumLabel = new JLabel("89,89 \u20AC");
		sumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sumLabel.setBounds(609, 398, 50, 19);
		warenkorbPanel.add(sumLabel);
		
		JButton btnNewButton_2 = new JButton("Bezahlvorgang starten");
		btnNewButton_2.setBackground(new Color(0, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(573, 423, 104, 40);
		warenkorbPanel.add(btnNewButton_2);
	}
}
