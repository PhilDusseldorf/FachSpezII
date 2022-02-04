package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 300, 640, 480);
		frame.setTitle("Demo03BorderLayout");
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		frame.setContentPane(panel);

		panel.setLayout(new BorderLayout(10, 10));
		JButton btnNorth = new JButton("North");
        JButton btnWest = new JButton("West");
		JButton btnSouth = new JButton("South");
		JButton btnCenter = new JButton("Center");
		// JButton btnEast = new JButton("East");

		panel.add(btnNorth, BorderLayout.NORTH);
		panel.add(btnWest,BorderLayout.WEST);
		panel.add(btnSouth, BorderLayout.SOUTH);
		panel.add(btnCenter, BorderLayout.CENTER);
		// panel.add(btnEast, BorderLayout.EAST); // No need for eastpanel
		
		frame.setVisible(true);
    }
}
