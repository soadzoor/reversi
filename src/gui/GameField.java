package gui;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.CheckScissors;



public class GameField extends JPanel {
	private static GameButton[][] buttons;
	public static boolean isWhiteTurn;
	public static boolean showPos;
	public JLabel statusBar;
	private String labelString;
	GameField frame;
	
	public GameField(int n) {
		setVisible(true);
		setLayout(new GridLayout(n,n,0,0));
		buttons = new GameButton[n][n];
		isWhiteTurn = true;
		GameField frame = this;
		frame.setLocation(20, 20);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				GameButton b = new GameButton();
				buttons[i][j] = b;
				
				ButtonAction buttonAction = new ButtonAction();
				buttonAction.x = i;
				buttonAction.y = j;
				buttonAction.b = b;
				b.addActionListener(buttonAction);
				this.add(b);
			}
		}
		
		buttons[n/2 -1][n/2 -1].setIconWhite();
		buttons[n/2][n/2].setIconWhite();
		buttons[n/2 -1][n/2].setIconBlack();
		buttons[n/2][n/2 -1].setIconBlack();
		
		
		if (showPos) {
			whereCanWhiteTurn();
		}
		
	}
	public JButton get(int i, int j) {
		return buttons[i][j];
	}
	private boolean canWhiteTurn() {
		for (int i = 0; i < buttons.length; ++i) {
			for (int j = 0; j < buttons.length; ++j) {
				if (CheckScissors.isWhiteValid(i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	void whereCanWhiteTurn() {
		for (int i = 0; i < buttons.length; ++i) {
			for (int j = 0; j < buttons.length; ++j) {
				if (CheckScissors.isWhiteValid(i, j)) {
					buttons[i][j].setBackground(Color.YELLOW);
					buttons[i][j].setOpaque(true);
				}
				else {
					buttons[i][j].setBackground(null);
					buttons[i][j].setOpaque(true);
				}
			}
		}
	}
	private boolean canBlackTurn() {
		for (int i = 0; i < buttons.length; ++i) {
			for (int j = 0; j < buttons.length; ++j) {
				if (CheckScissors.isBlackValid(i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	void whereCanBlackTurn() {
		for (int i = 0; i < buttons.length; ++i) {
			for (int j = 0; j < buttons.length; ++j) {
				if (CheckScissors.isBlackValid(i, j)) {
					buttons[i][j].setBackground(Color.YELLOW);
					buttons[i][j].setOpaque(true);
				}
				else {
					buttons[i][j].setBackground(null);
					buttons[i][j].setOpaque(true);
				}
			}
		}
	}
	private boolean gameActive() {
		return (canBlackTurn() || canWhiteTurn());
	}
	private void showResult() {
		if (!canWhiteTurn() && !canBlackTurn()) {
			if (whoWon() == 0) {
				BoxLayoutFrame.refresh();
				JOptionPane.showMessageDialog(frame, "It's a draw!");
			}
			if (whoWon() == 1) {
				BoxLayoutFrame.refresh();
				JOptionPane.showMessageDialog(frame, "White won!");
			}
			if (whoWon() == 2) {
				BoxLayoutFrame.refresh();
				JOptionPane.showMessageDialog(frame, "Black won!");
			}
		}
	}
	private int whoWon() {
		if (sumBlacks() < sumWhites()) {
			return 1; //white won
		}
		else if (sumBlacks() > sumWhites()) {
			return 2; //black won
		}
		return 0; //draw
	}
	public int sumBlacks() {
		int db = 0;
		for (int i = 0; i < buttons.length; ++i) {
			for (int j = 0; j < buttons.length; ++j) {
				if (!buttons[i][j].isWhite() && !buttons[i][j].isEmpty()) {
					db++;
				}
			}
		}
		return db;
	}
	public int sumWhites() {
		int db = 0;
		for (int i = 0; i < buttons.length; ++i) {
			for (int j = 0; j < buttons.length; ++j) {
				if (buttons[i][j].isWhite()) {
					db++;
				}
			}
		}
		return db;
	}
	
	public String getLabel() {
		return labelString;
	}
	
	
	public class ButtonAction implements ActionListener {
		public int x;
		public int y;
		public GameButton b;
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!b.isEmpty()) {
				return;
			}
			
			
			if (isWhiteTurn) {
				if (!canWhiteTurn()) {
					isWhiteTurn = !isWhiteTurn;
					if (showPos) {
						whereCanBlackTurn();
					}
					BoxLayoutFrame.refresh();
					return;
				}
				if (!CheckScissors.isWhiteValid(x, y)) {
					return;
				}
				b.setIconWhite();
				
				CheckScissors.checkScissorsBlack(x, y);
				if (!gameActive()) {
					showResult();
				}
			}
			else if (!isWhiteTurn) {
				if (!canBlackTurn()) {
					isWhiteTurn = !isWhiteTurn;
					if (showPos) {
						whereCanWhiteTurn();
					}
					BoxLayoutFrame.refresh();
					return;
				}
				if (!CheckScissors.isBlackValid(x, y)) {
					return;
				}
				b.setIconBlack();
				CheckScissors.checkScissorsWhite(x, y);
				if (!gameActive()) {
					showResult();
				}
			}
			
			
			if (showPos) {
				if (isWhiteTurn) {
					whereCanBlackTurn();
				}
				else {
					whereCanWhiteTurn();
				}
			}
			isWhiteTurn = !isWhiteTurn;
			BoxLayoutFrame.refresh();
			
		}
	};
	
	
	public static GameButton[][] getButtons() {
		return buttons;
	}
}