package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Artikel extends JPanel implements ActionListener{
	private JButton albumIcon;
	private Icon icon;
	private JLabel albumTitle;
	private JLabel albumArtist;
	private JLabel albumPrice;
	private JButton btnBuy;
	private MyFrame window;
	
	
	public Artikel(MyFrame myFrame) {
		this.window = myFrame;
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		icon = new ImageIcon("C:\\Users\\CC-Student\\Desktop\\Hausaufgaben\\FachSpezII\\bald-men-2206811-1841376.png");
		albumIcon = new JButton(icon);
		albumIcon.addActionListener(this);
		
		albumTitle = new JLabel("Albumtitel");
		albumTitle.setHorizontalAlignment(SwingConstants.CENTER);
		albumTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		albumArtist = new JLabel("Interpret");
		
		albumPrice = new JLabel("Preis: 7,99 \u20AC");
		
		btnBuy = new JButton("Kaufen");
		btnBuy.addActionListener(this);
		
		this.add(albumIcon);
		
		this.add(albumTitle);
		
		this.add(albumArtist);
		
		this.add(albumPrice);
		
		this.add(btnBuy);
	}
	
	private void createProduktdetails() {
		// the dialogs own window frame
		JFrame frame = new JFrame();
		frame.setResizable(false);
		// the actual dialog "panel"
        JDialog dialog = new JDialog(frame , "Produktdetails");

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
		
		JLabel album = new JLabel("New label");
		album.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(album);
		
		JLabel lblInterpret = new JLabel("Interpret");
		lblInterpret.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInterpret.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblInterpret);
		
		JLabel artist = new JLabel("New label");
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
		beschreibung.setText("Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla.");
		beschreibung.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(beschreibung);
		
		JLabel lblPreis = new JLabel("Preis");
		lblPreis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreis.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblPreis);
		
		JLabel preis = new JLabel("7,99");
		preis.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(preis);
		
		boxLeft.add(btnBuy);	// this button already exists in this class, so I just add it
		
		JPanel boxRight = new JPanel();
		boxRight.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPanel.add(boxRight);
		boxRight.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setMinimumSize(new Dimension(255,255));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon("C:\\Users\\CC-Student\\Desktop\\Hausaufgaben\\FachSpezII\\bald-men-2206811-1841376.png"));
		boxRight.add(lblIcon, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		boxRight.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblKategorien = new JLabel("Kategorien");
		lblKategorien.setVerticalAlignment(SwingConstants.TOP);
		lblKategorien.setHorizontalAlignment(SwingConstants.LEFT);
		lblKategorien.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblKategorien);
		
		JLabel kategorien = new JLabel("KAtegorie1, KAtegorie2");
		kategorien.setVerticalAlignment(SwingConstants.TOP);
		kategorien.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(kategorien);

        dialog.add(mainPanel);

        // set bounds of dialog
        int dialogWidth = 400;
        int dialogHeight = 400;
        dialog.setSize(dialogWidth, dialogHeight);
        dialog.setLocationRelativeTo(window);

        // set visibility of dialog
        dialog.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuy) {
			System.out.println("Popup für Kauf soll öffnen...");
			JOptionPane.showMessageDialog(this, "Der Artikel wurde im Warenkorb gespeichert.", "Artikel gemerkt", JOptionPane.PLAIN_MESSAGE);
		}
		
		if (e.getSource() == albumIcon) {
			System.out.println("Popup für Details soll öffnen...");
			createProduktdetails();
		}
	}
}
