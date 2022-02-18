package com.kladusch.app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
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
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.GridLayout;

public class Bestellung extends MyPanel implements ActionListener {
	private WarenList warenList;

	private JTextField fldVorname;
	private JTextField fldNachname;
	private JTextField fldStrasse;
	private JTextField fldHausnummer;
	private JTextField fldStadt;
	private JTextField fldPLZ;
	
	private JPanel datenPanel;
	private JButton btnBestellen;
	private JButton btnWarenkorb2;
	private JRadioButton rdbtnNachnahme;
	private JRadioButton rdbtnRechnung;
	private ButtonGroup btngRadioButtons;
	private JCheckBox chckbxAGB;

	public Bestellung(MyFrame frame) {
		super(frame);
		
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(0, 100, 0, 0));
		this.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		
		datenPanel = new JPanel();
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
		
		fldVorname = new JTextField();
		fldVorname.setColumns(1);
		fldVorname.setSize(100, 50);
		datenPanel.add(fldVorname);
		
		JLabel lblNachname = new JLabel("Nachname");
		datenPanel.add(lblNachname);
		
		fldNachname = new JTextField();
		fldNachname.setColumns(1);
		datenPanel.add(fldNachname);
		
		JLabel lblStrasse = new JLabel("Strasse");
		datenPanel.add(lblStrasse);
		
		fldStrasse = new JTextField();
		fldStrasse.setColumns(1);
		datenPanel.add(fldStrasse);
		
		JLabel lblHausnummer = new JLabel("Hausnummer");
		lblHausnummer.setVerticalAlignment(SwingConstants.TOP);
		datenPanel.add(lblHausnummer);
		
		fldHausnummer = new JTextField();
		fldHausnummer.setColumns(1);
		datenPanel.add(fldHausnummer);
		
		JLabel lblStadt = new JLabel("Stadt");
		datenPanel.add(lblStadt);
		
		fldStadt = new JTextField();
		fldStadt.setColumns(1);
		datenPanel.add(fldStadt);
		
		JLabel lblPLZ = new JLabel("PLZ");
		datenPanel.add(lblPLZ);
		
		fldPLZ = new JTextField();
		fldPLZ.setColumns(1);
		datenPanel.add(fldPLZ);
		
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
		btnBestellen.setBounds(348, 423, 200, 40);
		btnBestellen.addActionListener(this);
		bestellPanel.add(btnBestellen);
		
		btnWarenkorb2 = new JButton("Zur\u00FCck zum Warenkorb");
		btnWarenkorb2.setBackground(UIManager.getColor("Button.background"));
		btnWarenkorb2.setBounds(121, 423, 200, 40);
		btnWarenkorb2.addActionListener(this);
		bestellPanel.add(btnWarenkorb2);
		
		rdbtnRechnung = new JRadioButton("auf Rechnung");
		rdbtnRechnung.setBounds(73, 272, 109, 23);
		bestellPanel.add(rdbtnRechnung);
		
		rdbtnNachnahme = new JRadioButton("per Nachnahme");
		rdbtnNachnahme.setBounds(73, 298, 109, 23);
		bestellPanel.add(rdbtnNachnahme);
		
		btngRadioButtons = new ButtonGroup();
		btngRadioButtons.add(rdbtnRechnung);
		btngRadioButtons.add(rdbtnNachnahme);
		
		chckbxAGB = new JCheckBox("ich stimme den AGB zu.");
		chckbxAGB.setBounds(224, 298, 170, 23);
		bestellPanel.add(chckbxAGB);
		
		
	}
	
	private void getDataForBestellung() {
		// only prints the data to the console yet
		System.out.println(
			fldVorname.getText()+ "/" +
			fldNachname.getText()+ "/" +
			fldStrasse.getText()+ "/" +
			fldHausnummer.getText()+ "/" +
			fldStadt.getText()+ "/" +
			fldPLZ.getText()
		);
		if (rdbtnNachnahme.isSelected()) {
			System.out.println(rdbtnNachnahme.getText());
		}
		
		if (rdbtnRechnung.isSelected()) {
			System.out.println(rdbtnRechnung.getText());
		}
			
		System.out.println(
				"AGB accepted : " + chckbxAGB.isSelected()
		);
		
	}
	
	private boolean isEverythingCovered() {
		
		for (Component comp : datenPanel.getComponents()) { 
			if (comp instanceof JTextField) { 
				if (((JTextField)comp).getText().isBlank()) {
					JOptionPane.showMessageDialog(
							this,
							"Eines der Textfelder ist leer. Bitte füllen Sie das Formularfeld komplett aus.",
							"Eingabefehler", 
							JOptionPane.WARNING_MESSAGE
							); 
					return false; 
				} 
			} 
		}
		 

		if (btngRadioButtons.getSelection() == null) {
			JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Zahlungsmethode.", "Zahlungsmethode", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (!chckbxAGB.isSelected()) {
			JOptionPane.showMessageDialog(this, "Bitte stimmen Sie den Allgemeinen GeschäftsBedingungen(AGB) zu, wenn Sie eine Bestellung aufgeben möchten.", "AGB", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBestellen && isEverythingCovered()) {
			getDataForBestellung();
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
