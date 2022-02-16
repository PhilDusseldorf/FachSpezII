package com.kladusch.app.model;

public class BuyItem {
	private int amount;
	private String album;
	private String artist;
	private double price;
	private int id;
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if (amount <= 0) {
			this.amount = 1;
		} else {
			this.amount = amount;
		}
	}

	public BuyItem(int amount, String artist, String album, double price, int id) {
		this.amount = amount;
		this.artist = artist;
		this.album = album;
		this.price = price;
		this.id = id;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}
	
	public int getID() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
}
