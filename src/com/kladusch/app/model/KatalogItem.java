package com.kladusch.app.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class KatalogItem {
	public final int id;
	public final String nameAlbum;
	public final String nameArtist;
	public final String beschreibungString;
	public final Double price;
	public final List<String> kategorienList;
	public ImageIcon imageIcon;
	
	public KatalogItem (int id, String album, String artist, String description, Double price) {
		this.imageIcon = new ImageIcon("./res/placeholder.png");	// this is the placeholder in case no picture is found
		this.id = id;
		this.nameAlbum = album;
		this.nameArtist = artist;
		this.beschreibungString = description;
		this.price = price;
		this.kategorienList = new ArrayList<>();
	}

}
