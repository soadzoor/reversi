package gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameButton extends JButton {
	private ImageIcon white;
	private ImageIcon black;
	private boolean isBlack;
	private boolean isEmpty;
	
	
	
	public GameButton() {
		super();
		isBlack = false;
		isEmpty = true;
		try {
			BufferedImage buffWhite = ImageIO.read(new File("img/white30.png"));
	        white = new ImageIcon(buffWhite);
	        
	        BufferedImage buffBlack = ImageIO.read(new File("img/black30.png"));
	        black = new ImageIcon(buffBlack);
		} 
		catch (IOException e) {
			System.out.println("IOException! Check the image path!");
		}
		setPreferredSize( new Dimension(20, 40));
	}
	public void setIconBlank() {
		isEmpty = true;
		isBlack = false;
	}
	public void setIconBlack() {
		this.setIcon(black);
		isBlack = true;
		isEmpty = false;
	}
	public void setIconWhite() {
		this.setIcon(white);
		isBlack = false;
		isEmpty = false;
	}
	public boolean isWhite() {
		return (!isBlack && !isEmpty);
	}
	public boolean isBlack() {
		return isBlack;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	
}
