package com.kladusch.app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.MyPanel;
import com.kladusch.app.model.MainModel;
import com.kladusch.app.MyFrame;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class Bestellung extends MyPanel implements ActionListener {
	private WarenList warenList;

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private JButton btnBestellen;
	private JButton btnWarenkorb2;

	public Bestellung(MyFrame frame) {
		super(frame);
		
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(0, 100, 0, 0));
		this.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		
		JPanel datenPanel = new JPanel();
		datenPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		datenPanel.setLayout(new GridLayout(0, 1, 0, 0));
		datenPanel.setMinimumSize(new Dimension(400,600));
		datenPanel.setSize(new Dimension(400,600));
		westPanel.add(datenPanel);
		
		JLabel headerKundendaten = new JLabel("Kundendaten");
		headerKundendaten.setFont(new Font("Tahoma", Font.BOLD, 11));
		datenPanel.add(headerKundendaten);
		
		JLabel lblVorname = new JLabel("Vorname");
		datenPanel.add(lblVorname);
		
		textField_1 = new JTextField();
		textField_1.setColumns(1);
		textField_1.setSize(100, 50);
		datenPanel.add(textField_1);
		
		JLabel lblNachname = new JLabel("Nachname");
		datenPanel.add(lblNachname);
		
		textField_2 = new JTextField();
		textField_2.setColumns(1);
		datenPanel.add(textField_2);
		
		JLabel lblStrasse = new JLabel("Strasse");
		datenPanel.add(lblStrasse);
		
		textField_3 = new JTextField();
		textField_3.setColumns(1);
		datenPanel.add(textField_3);
		
		JLabel lblHausnummer = new JLabel("Hausnummer");
		lblHausnummer.setVerticalAlignment(SwingConstants.TOP);
		datenPanel.add(lblHausnummer);
		
		textField_4 = new JTextField();
		textField_4.setColumns(1);
		datenPanel.add(textField_4);
		
		JLabel lblStadt = new JLabel("Stadt");
		datenPanel.add(lblStadt);
		
		textField_5 = new JTextField();
		textField_5.setColumns(1);
		datenPanel.add(textField_5);
		
		JLabel lblPLZ = new JLabel("PLZ");
		datenPanel.add(lblPLZ);
		
		textField_6 = new JTextField();
		textField_6.setColumns(1);
		datenPanel.add(textField_6);
		
		JPanel spacingPanel = new JPanel();
		westPanel.add(spacingPanel);
		
		JPanel bestellPanel = new JPanel();
		bestellPanel.setLayout(null);
		this.add(bestellPanel, BorderLayout.CENTER);
		
		JLabel lblBestellung = new JLabel("Bestellung");
		lblBestellung.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestellung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBestellung.setBounds(50, 11, 85, 22);
		bestellPanel.add(lblBestellung);
		
		// here the warenkorbItems are shown
		warenList = new WarenList(frame);
		warenList.loadBestellung();
		
		JScrollPane warenkorbItems = new JScrollPane(warenList, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		warenkorbItems.setViewportBorder(new EmptyBorder(10, 10, 10, 10));
		warenkorbItems.setBounds(50, 33, 480, 232);
		bestellPanel.add(warenkorbItems);
		
		JLabel lblZuZahlen = new JLabel("Gesamt zu Zahlen:");
		lblZuZahlen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZuZahlen.setBounds(238, 396, 142, 22);
		bestellPanel.add(lblZuZahlen);
		
		JLabel sumLabel = new JLabel(frame.getMainModel().getZuZahlen());
		sumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sumLabel.setBounds(390, 398, 50, 19);
		bestellPanel.add(sumLabel);
		
		btnBestellen = new JButton("Bezahlvorgang starten");
		btnBestellen.setBackground(new Color(0, 128, 0));
		btnBestellen.setBounds(348, 423, 104, 40);
		btnBestellen.addActionListener(this);
		bestellPanel.add(btnBestellen);
		
		btnWarenkorb2 = new JButton("Zur\u00FCck zum Warenkorb");
		btnWarenkorb2.setBackground(UIManager.getColor("Button.background"));
		btnWarenkorb2.setBounds(221, 423, 104, 40);
		btnWarenkorb2.addActionListener(this);
		bestellPanel.add(btnWarenkorb2);
		
		JRadioButton rdbtnRechnung = new JRadioButton("auf Rechnung");
		rdbtnRechnung.setBounds(73, 272, 109, 23);
		bestellPanel.add(rdbtnRechnung);
		
		JRadioButton rdbtnNachnahme = new JRadioButton("per Nachnahme");
		rdbtnNachnahme.setBounds(73, 298, 109, 23);
		bestellPanel.add(rdbtnNachnahme);
		
		JCheckBox chckbxAGB = new JCheckBox("ich stimme den AGB zu.");
		chckbxAGB.setBounds(224, 298, 170, 23);
		bestellPanel.add(chckbxAGB);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBestellen) {
			System.out.println("Bestellung abgeschickt!");
			JOptionPane.showMessageDialog(this, "Die Bestellung wird nun von uns bearbeitet.", "Bestellung aufgegeben", JOptionPane.PLAIN_MESSAGE);
			model.getBuyList().clear();
			frame.changePanel(frame.getSortPanel());
		}
		
		if (e.getSource() == btnWarenkorb2) {
			frame.changePanel(frame.getWarenPanel());
		}
		
	}
}
