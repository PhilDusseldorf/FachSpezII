package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TestLayout extends JFrame {

	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestLayout frame = new TestLayout();
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
	public TestLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 451);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		JPanel boxLeft = new JPanel();
		boxLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPanel.add(boxLeft);
		boxLeft.setLayout(new BoxLayout(boxLeft, BoxLayout.Y_AXIS));
		
		JLabel lblAlbum = new JLabel("Albumtitel");
		lblAlbum.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxLeft.add(lblAlbum);
		
		JLabel album = new JLabel("New label");
		album.setHorizontalAlignment(SwingConstants.LEFT);
		boxLeft.add(album);
		
		JLabel lblInterpret = new JLabel("Interpret");
		lblInterpret.setHorizontalAlignment(SwingConstants.LEFT);
		lblInterpret.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxLeft.add(lblInterpret);
		
		JLabel artist = new JLabel("New label");
		artist.setHorizontalAlignment(SwingConstants.LEFT);
		boxLeft.add(artist);
		
		JLabel lblBeschr = new JLabel("Beschreibung");
		lblBeschr.setHorizontalAlignment(SwingConstants.LEFT);
		lblBeschr.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxLeft.add(lblBeschr);
		
		JTextPane txtpnEinWunderbaresAlbum = new JTextPane();
		txtpnEinWunderbaresAlbum.setText("Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla. Ein wunderbares Album voller Lieder und Blabla.");
		boxLeft.add(txtpnEinWunderbaresAlbum);
		
		JLabel lblPreis = new JLabel("Preis");
		lblPreis.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreis.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxLeft.add(lblPreis);
		
		JLabel preis = new JLabel("7,99");
		preis.setHorizontalAlignment(SwingConstants.LEFT);
		boxLeft.add(preis);
		
		JButton btnBuy = new JButton("kaufen");
		boxLeft.add(btnBuy);
		
		JPanel boxRight = new JPanel();
		mainPanel.add(boxRight);
		boxRight.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcon = new JLabel("");
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
	}

}
