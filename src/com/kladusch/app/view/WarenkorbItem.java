package com.kladusch.app.view;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Optional;

import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;

import com.kladusch.app.MyFrame;
import com.kladusch.app.model.BuyItem;
import com.kladusch.app.model.MainModel;

import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class WarenkorbItem extends JPanel implements ActionListener {
	private final int width = 470;
	private final int height = 40;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance(getDefaultLocale());
	
	private MyFrame frame;
	
	private JLabel lblNameAlbum;
	private JLabel lblNameArtist;
	private JLabel lblSinglePrice;
	private JSpinner spinAmount;
	private JLabel lblSumPrice;
	private JButton btnRemove;
	
	// the values for the labels
	private double singlePrice;
	private int  amount = 1;
	private double sumPrice;
	private int id;
	
	public double getSumPrice() {
		return sumPrice;
	}

	public WarenkorbItem(BuyItem item, MyFrame frame) {
		this.setSize(width, height);
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.frame = frame;
		this.amount = item.getAmount();
		this.id = item.getID();
		singlePrice = item.getPrice();
		
		sumPrice = singlePrice * amount;
		setLayout(new GridLayout(0, 6, 0, 0));
		
		lblNameAlbum = new JLabel(item.getAlbum());
		lblNameAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameAlbum);
		
		lblNameArtist = new JLabel(item.getArtist());
		lblNameArtist.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNameArtist);
		
		lblSinglePrice = new JLabel(formatter.format(singlePrice));
		lblSinglePrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSinglePrice);
		
		spinAmount = new JSpinner();
		spinAmount.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinAmount.setValue(Integer.valueOf(amount));
		spinAmount.addChangeListener(new ChangeListener(){
		      public void stateChanged(javax.swing.event.ChangeEvent ce){
		          System.out.println("Spinner changed to " + spinAmount.getValue());
		      }
		});
		add(spinAmount);
		
		lblSumPrice = new JLabel(formatter.format(sumPrice));
		lblSumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSumPrice);
		
		btnRemove = new JButton("X");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnRemove.addActionListener(this);
		add(btnRemove);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRemove ) {
			System.out.println("Item soll entfernt werden.");
			Optional<BuyItem> option = MainModel.buyList.stream().filter(o -> o.getID() == id).findFirst();
			option.ifPresent(opt -> {for (BuyItem item : MainModel.buyList) {
				if (item.getID() == opt.getID()) {MainModel.buyList.remove(item);break;}
			}});
			((Warenkorb)frame.getWarenPanel()).getWarenList().loadWarenkorbItems();
            ((Warenkorb)frame.getWarenPanel()).refreshZuZahlen();
            frame.changePanel(frame.getWarenPanel());
		}
		
	}
}
