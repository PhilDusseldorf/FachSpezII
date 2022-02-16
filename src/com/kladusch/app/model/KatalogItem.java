package com.kladusch.app.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class KatalogItem {
	public final Icon icon;
	public final int id;
	public final String nameAlbum;
	public final String nameArtist;
	public final String beschreibungString;
	public final Double price;
	public final List<String> kategorienList;
	
	public KatalogItem (int id, String album, String artist, String description, Double price) {
		this.icon = new ImageIcon("./bald-man.png");	// the icon does not come from the database yet
		this.id = id;
		this.nameAlbum = album;
		this.nameArtist = artist;
		this.beschreibungString = description;
		this.price = price;
		this.kategorienList = new ArrayList<>();
	}

}
