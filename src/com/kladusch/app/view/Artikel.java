package com.kladusch.app.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
import com.kladusch.app.model.KatalogItem;
import com.kladusch.app.model.MainModel;

public class Artikel extends JPanel implements ActionListener{
	private JLabel lblAlbumTitle;
	private JLabel lblAlbumArtist;
	private JLabel lblAlbumPrice;
	private String priceString;
	private JButton btnAlbumIcon;
	private JButton btnBuy;
	private JButton btnBuy2;
	private MyFrame window;
	private JDialog dialog;
	private MainModel model;
	
	// infos from ArrayList
	private int id;
	private ImageIcon icon;
	private String nameAlbum;
	private String nameArtist;
	private String beschreibungString;
	private Double price;
	private List<String> kategorienList;
	
	// constants
	private final Font fntBold = new Font("Tahoma", Font.BOLD, 11);
	private final Font fntStnd = new Font("Tahoma", Font.PLAIN, 11);
	private NumberFormat formatter = NumberFormat.getCurrencyInstance(getDefaultLocale());
	
	public Artikel(MyFrame myFrame, KatalogItem item, MainModel model) {
		this.window = myFrame;
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.model = model;
		
		kategorienList = new ArrayList<String>(item.kategorienList);
		
		id = item.id;
		icon = item.imageIcon;
		
		btnAlbumIcon = new JButton(scaleIcon(64,64));
		btnAlbumIcon.addActionListener(this);
		
		nameAlbum = item.nameAlbum;
		lblAlbumTitle = new JLabel(nameAlbum);
		lblAlbumTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumTitle.setFont(fntBold);
		
		nameArtist = item.nameArtist;
		lblAlbumArtist = new JLabel(nameArtist);
		
		price = item.price;

		priceString = formatter.format(price);
		lblAlbumPrice = new JLabel(priceString);
		
		beschreibungString = item.beschreibungString;
		
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
        dialog = new JDialog(frame , "Produktdetails");
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
		lblAlbum.setFont(fntBold);
		lblAlbum.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblAlbum);
		
		JLabel album = new JLabel(nameAlbum);
		album.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(album);

		JLabel lblInterpret = new JLabel("Interpret");
		lblInterpret.setFont(fntBold);
		lblInterpret.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblInterpret);
		
		JLabel artist = new JLabel(nameArtist);
		artist.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(artist);

		JLabel lblBeschr = new JLabel("Beschreibung");
		lblBeschr.setFont(fntBold);
		lblBeschr.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblBeschr);
		
		JTextArea beschreibung = new JTextArea();
		beschreibung.setLineWrap(true);
		beschreibung.setWrapStyleWord(true);
		beschreibung.setFont(fntStnd);
		beschreibung.setText(beschreibungString);
		beschreibung.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(beschreibung);

		JLabel lblPreis = new JLabel("Preis");
		lblPreis.setFont(fntBold);
		lblPreis.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(lblPreis);
		
		JLabel preis = new JLabel(priceString);
		preis.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxLeft.add(preis);
		
		btnBuy2 = new JButton("Kaufen");
		btnBuy2.addActionListener(this);
		boxLeft.add(btnBuy2);
		
		JPanel boxRight = new JPanel();
		boxRight.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPanel.add(boxRight);
		boxRight.setLayout(new BorderLayout(0, 0));

		JLabel lblIcon = new JLabel(scaleIcon(128,128));
		lblIcon.setMinimumSize(new Dimension(255,255));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		boxRight.add(lblIcon, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		boxRight.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblKategorien = new JLabel("Kategorien");
		lblKategorien.setVerticalAlignment(SwingConstants.TOP);
		lblKategorien.setHorizontalAlignment(SwingConstants.LEFT);
		lblKategorien.setFont(fntBold);
		panel.add(lblKategorien);
		
		JTextArea kategorien = new JTextArea(String.join(", ", kategorienList));
		kategorien.setLineWrap(true);
		kategorien.setWrapStyleWord(true);
		kategorien.setFont(fntStnd);
		kategorien.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(kategorien);

        dialog.add(mainPanel);

        // set visibility of dialog
        dialog.setVisible(true);
	}
	
	private ImageIcon scaleIcon(int width, int height) {
		Image image = icon.getImage();
		ImageIcon resized = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_FAST));
		return resized;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuy || e.getSource() == btnBuy2) {
			System.out.println("Popup f?r Kauf soll ?ffnen...");
			model.addArtikelToWarenkorb(nameArtist, nameAlbum, price, id);
			if (e.getSource() == btnBuy2) {
				dialog.setVisible(false);
			}
			JOptionPane.showMessageDialog(this, "Der Artikel wurde im Warenkorb gespeichert.", "Artikel gemerkt", JOptionPane.PLAIN_MESSAGE);
		}
		
		if (e.getSource() == btnAlbumIcon) {
			System.out.println("Popup f?r Details soll ?ffnen...");
			createProduktdetails();
		}
	}
}
