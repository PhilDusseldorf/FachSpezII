package com.kladusch.app;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kladusch.app.view.TopMenu;
import com.kladusch.app.MyFrame;
import com.kladusch.app.model.MainModel;

public class MyPanel extends JPanel {
	protected MyFrame frame;
	protected TopMenu topMenu;
	protected MainModel model;
	
	public MyPanel(MyFrame frame) {
		this.frame = frame;
		this.model = frame.getMainModel();
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(10, 10));
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		topMenu = new TopMenu(this.frame);
		this.add(topMenu, BorderLayout.NORTH);
	}
}
