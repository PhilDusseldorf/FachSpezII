package com.kladusch.app.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import com.kladusch.app.MyFrame;
import com.kladusch.app.MyPanel;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Prototyp extends MyPanel {

	public Prototyp(MyFrame frame) {
		super(frame);
		
		JPanel introPanel = new JPanel();
		introPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		introPanel.setLayout(new BorderLayout(0, 0));
		this.add(introPanel, BorderLayout.CENTER);
		
		JLabel headerLabel = new JLabel("Willkommen CD-Nostalgiker");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		introPanel.add(headerLabel, BorderLayout.NORTH);
		
		JTextArea introText = new JTextArea();
		introText.setLineWrap(true);
		introText.setWrapStyleWord(true);
		introText.setText("Du bist genau richtig hier im myCD-shop. Wir bieten hochmoderne CompactDisks an, die du in deinen CD-Spieler oder auch in deinen Discman packen kannst. Gibt es etwas praktischeres als einen Diskman, um unterwegs seine Lieblingsmusik zu hören? Sicher nicht! Darum hole dir hier das beste Futter für deine Ohren. Von A wie Adele bis X wie Xavier Naidoo findest du hier die größten Stars der Musikbranche. Tatsächlich haben wir keine CDs von Interpreten, die mit Y oder Z beginnen.");
		introPanel.add(introText, BorderLayout.CENTER);
		
		int imgPixels = 410;
		JLabel welcomeIcon = new JLabel(new ImageIcon((new ImageIcon("C:\\Users\\CC-Student\\Desktop\\Hausaufgaben\\FachSpezII\\icon-placeholder-14.jpg")).getImage().getScaledInstance(imgPixels, imgPixels, 0)));
		welcomeIcon.setForeground(UIManager.getColor("Button.disabledForeground"));
		welcomeIcon.setBorder(new EmptyBorder(0, 10, 0, 0));
		welcomeIcon.setBackground(new Color(105, 105, 105));
		introPanel.add(welcomeIcon, BorderLayout.EAST);
	}

}
