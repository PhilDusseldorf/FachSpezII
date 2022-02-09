package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class App {
	
    public static void main(String[] args) throws Exception {
    	// Frame
    	MyFrame frame = new MyFrame();
        
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
