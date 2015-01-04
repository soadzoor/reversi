package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import model.CheckScissors;

public class BoxLayoutFrame extends JFrame {
	private static JLabel statusBar;
	private Action action8 = new Action8();
    private Action action10 = new Action10();
    private Action action20 = new Action20();
    private Action action30 = new Action30();
    private Action showPos = new showPos();
    private Action hidePos = new hidePos();
    private static JPanel startPanel;
    private JButton button8;
    private JButton button10;
    private JButton button20;
    private JButton button30;
    private static GameField gameField;

    
	public BoxLayoutFrame() {
		setSize(400,500);
		setTitle("Reversi");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.X_AXIS));
		startPanel.setBorder(BorderFactory.createEmptyBorder(180, 80, 180, 80));
        add(startPanel);
        button8 = new JButton(action8);
        button10 = new JButton(action10);
        button20 = new JButton(action20);
        button30 = new JButton(action30);
        startPanel.add(button8);
        startPanel.add(Box.createRigidArea(new Dimension(15,0)));
        startPanel.add(button10);
        startPanel.add(Box.createRigidArea(new Dimension(15,0)));
        startPanel.add(button20);
        startPanel.add(Box.createRigidArea(new Dimension(15,0)));
        startPanel.add(button30);
        statusBar = new JLabel("Start a new game!");
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        add(statusBar, BorderLayout.SOUTH);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu statusBarMenu = new JMenu("New Game");
        JMenu options = new JMenu("Options");
        
        menuBar.add(statusBarMenu);
        menuBar.add(options);
        
        
        
        statusBarMenu.add(new JMenuItem(action8));
        statusBarMenu.add(new JMenuItem(action10));
        statusBarMenu.add(new JMenuItem(action20));
        statusBarMenu.add(new JMenuItem(action30));
        
        options.add(new JMenuItem(showPos));
        options.add(new JMenuItem(hidePos));
        
        
        
        pack();
        this.setResizable(false);
        
        
	}
	
	private void newGame(int n) {
		
    	startPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    	startPanel.removeAll();
    	
        gameField = new GameField(n);
        
        setLocationRelativeTo(null);
        startPanel.add(gameField);
        startPanel.remove(statusBar);
        //
        statusBar.setText("Whites: " + Integer.toString(gameField.sumWhites())+ " Blacks: " + Integer.toString(gameField.sumBlacks()) + "             white's turn");
        CheckScissors.clear();
        startPanel.revalidate();
	}
	public static void refresh() {
		if (gameField.isWhiteTurn) {
			statusBar.setText("Whites: " + Integer.toString(gameField.sumWhites())+ " Blacks: " + Integer.toString(gameField.sumBlacks()) + "             white's turn");
		}
		else {
			statusBar.setText("Whites: " + Integer.toString(gameField.sumWhites())+ " Blacks: " + Integer.toString(gameField.sumBlacks()) + "             blacks's turn");
		}
        startPanel.revalidate();
	}
	
	private class showPos extends AbstractAction {
		public showPos() {
            super("Show possibilities");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	GameField.showPos = true;
        	if (gameField != null) {
        		if (gameField.isWhiteTurn) {
        			gameField.whereCanWhiteTurn();
        		}
        		else {
        			gameField.whereCanBlackTurn();
        		}
        		refresh();
        	}
        }
        
    }
	private class hidePos extends AbstractAction {
		public hidePos() {
            super("Hide possibilities");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	GameField.showPos = false;
        	if (gameField != null) {
        		GameButton[][] buttons = gameField.getButtons();
        		for (int i = 0; i < buttons.length; ++i) {
        			for (int j = 0; j < buttons.length; ++j) {
    					buttons[i][j].setBackground(null);
    					buttons[i][j].setOpaque(true);
        			}
        		}
        		refresh();
        	}
        }
        
    }
	private class Action8 extends AbstractAction {
		public Action8() {
            super("8x8");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	//
        	
        	//
        	newGame(8);
        	
        	setSize(380,450);
            
            
        }
        
    }
	
	
	private class Action10 extends AbstractAction {
		public Action10() {
            super("10x10");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	//
        	
        	//
        	newGame(10);
        	
        	setSize(400,470);
            
            
        }
        
    }
	private class Action20 extends AbstractAction {
        public Action20() {
            super("20x20");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            setSize(700,750);
            newGame(20);
            
        }
        
    }
	private class Action30 extends AbstractAction {
        public Action30() {
            super("30x30");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            setSize(1050,1080);
            newGame(30);
        
        }
	}
}
