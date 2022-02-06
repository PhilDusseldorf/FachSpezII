package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class Prototyp extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototyp frame = new Prototyp();
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
	public Prototyp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("MyCD-Store");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sortiment");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Warenkorb");
		panel.add(btnNewButton_1);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Willkommen CD-Nostalgiker");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JTextArea txtrJemandMussteJosef = new JTextArea();
		txtrJemandMussteJosef.setLineWrap(true);
		txtrJemandMussteJosef.setText("Jemand musste Josef K. verleumdet haben, denn ohne dass er etwas B\u00F6ses getan h\u00E4tte, wurde er eines Morgens verhaftet. \u00BBWie ein Hund!\u00AB sagte er, es war, als sollte die Scham ihn \u00FCberleben. Als Gregor Samsa eines Morgens aus unruhigen Tr\u00E4umen erwachte, fand er sich in seinem Bett zu einem ungeheueren Ungeziefer verwandelt. Und es war ihnen wie eine Best\u00E4tigung ihrer neuen Tr\u00E4ume und guten Absichten, als am Ziele ihrer Fahrt die Tochter als erste sich erhob und ihren jungen K\u00F6rper dehnte.");
		panel_1.add(txtrJemandMussteJosef, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Symbolbild");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.disabledForeground"));
		lblNewLabel_2.setBackground(new Color(105, 105, 105));
		lblNewLabel_2.setIcon(null);
		panel_1.add(lblNewLabel_2, BorderLayout.EAST);
	}

}
