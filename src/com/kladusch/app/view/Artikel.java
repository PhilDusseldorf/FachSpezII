package com.kladusch.app.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.MyFrame;

public class Artikel extends JPanel implements ActionListener{
	private JButton btnAlbumIcon;
	private JLabel lblAlbumTitle;
	private JLabel lblAlbumArtist;
	private JLabel lblAlbumPrice;
	private String priceString;
	private JButton btnBuy;
	private MyFrame window;
	
	// infos from database
	private Icon icon;
	private String nameAlbum = "Greatest Hits";
	private String nameArtist = "Adele";
	private String beschreibungString = "Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla.";
	private Double price = 7.99;
	private List<String> kategorienList = new ArrayList<>(Arrays.asList("DolleMucke", "SoGefühlvoll", "ZumTräumen", "Popmusik", "KillMePlease"));
	
	public Artikel(MyFrame myFrame) {
		this.window = myFrame;
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		icon = new ImageIcon("C:\\Users\\CC-Student\\Desktop\\Hausaufgaben\\FachSpezII\\bald-men-2206811-1841376.png");
		btnAlbumIcon = new JButton(icon);
		btnAlbumIcon.addActionListener(this);
		
		lblAlbumTitle = new JLabel(nameAlbum);
		lblAlbumTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblAlbumArtist = new JLabel(nameArtist);
		
		priceString = "Preis: " + String.valueOf(price) + " €";
		lblAlbumPrice = new JLabel(priceString);
		
		btnBuy = new JButton("Kaufen");
		btnBuy.addActionListener(this);
		
		this.add(btnAlbumIcon);
		
		this.add(lblAlbumTitle);
		
		this.add(lblAlbumArtist);
		
		this.add(lblAlbumPrice);
		
		this.add(btnBuy);
	}
	
	private void createProduktdetails() {
		// the dialogs own window frame
		JFrame frame = new JFrame();
		frame.setResizable(false);
		// the actual dialog "panel"
        JDialog dialog = new JDialog(frame , "Produktdetails");
        // set bounds of dialog
        int dialogWidth = 400;
        int dialogHeight = 400;
        dialog.setSize(dialogWidth, dialogHeight);
        dialog.setLocationRelativeTo(window);
        dialog.setResizable(false);

        // create the content
        JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		JPanel boxLeft = new JPanel();
		boxLeft.setBorder(new EmptyBorder(0, 20, 20, 20));
		boxLeft.setLayout(new BoxLayout(boxLeft, BoxLayout.Y_AXIS));
		mainPanel.add(boxLeft);
		
		JLabel lblAlbum = new JLabel("Albumtitel");
		lblAlbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlbum.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblAlbum);
		
		JLabel album = new JLabel(nameAlbum);
		album.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(album);
		
		JLabel lblInterpret = new JLabel("Interpret");
		lblInterpret.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInterpret.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblInterpret);
		
		JLabel artist = new JLabel(nameArtist);
		artist.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(artist);
		
		JLabel lblBeschr = new JLabel("Beschreibung");
		lblBeschr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBeschr.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblBeschr);
		
		JTextArea beschreibung = new JTextArea();
		beschreibung.setLineWrap(true);
		beschreibung.setWrapStyleWord(true);
		beschreibung.setFont(new Font("Tahoma", Font.PLAIN, 11));
		beschreibung.setText(beschreibungString);
		beschreibung.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(beschreibung);
		
		JLabel lblPreis = new JLabel("Preis");
		lblPreis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreis.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblPreis);
		
		JLabel preis = new JLabel(String.valueOf(price) + "€");
		preis.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(preis);
		
		boxLeft.add(btnBuy);	// this button already exists in this class, so I just add it
		
		JPanel boxRight = new JPanel();
		boxRight.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPanel.add(boxRight);
		boxRight.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcon = new JLabel(icon);
		lblIcon.setMinimumSize(new Dimension(255,255));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		//lblIcon.setIcon(icon);
		boxRight.add(lblIcon, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		boxRight.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblKategorien = new JLabel("Kategorien");
		lblKategorien.setVerticalAlignment(SwingConstants.TOP);
		lblKategorien.setHorizontalAlignment(SwingConstants.LEFT);
		lblKategorien.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblKategorien);
		
		JTextArea kategorien = new JTextArea(String.join(", ", kategorienList));
		kategorien.setLineWrap(true);
		kategorien.setWrapStyleWord(true);
		kategorien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		kategorien.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(kategorien);

        dialog.add(mainPanel);


        // set visibility of dialog
        dialog.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuy) {
			System.out.println("Popup für Kauf soll öffnen...");
			JOptionPane.showMessageDialog(this, "Der Artikel wurde im Warenkorb gespeichert.", "Artikel gemerkt", JOptionPane.PLAIN_MESSAGE);
		}
		
		if (e.getSource() == btnAlbumIcon) {
			System.out.println("Popup für Details soll öffnen...");
			createProduktdetails();
		}
	}
}
