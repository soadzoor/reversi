package model;

import gui.GameButton;
import gui.GameField;

import java.util.LinkedList;

public class CheckScissors {
	private static LinkedList<Coord> tempCoords = new LinkedList<Coord>();
	private static GameButton[][] buttons = GameField.getButtons();
	private static LinkedList<Coord> checkedCoords = new LinkedList<Coord>();
	
	public static void clear() {
		buttons = GameField.getButtons();
		tempCoords.clear();
		checkedCoords.clear();
		
	}
	
	
	
	private static void checkScissorsBlackNorth(int x, int y) {
		int i = x-1;
		int j = y;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i >= 0) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			i--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsBlackNorthEast(int x, int y) {
		int i = x-1;
		int j = y+1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i >= 0 && j < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			i--;
			j++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsBlackEast(int x, int y) {
		int i = x;
		int j = y+1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (j < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			j++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsBlackSouthEast(int x, int y) {
		int i = x+1;
		int j = y+1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i < buttons.length && j < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			i++;
			j++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsBlackSouth(int x, int y) {
		int i = x+1;
		int j = y;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			i++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsBlackSouthWest(int x, int y) {
		int i = x+1;
		int j = y-1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (j >= 0 && i < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			i++;
			j--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsBlackWest(int x, int y) {
		int i = x;
		int j = y-1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (j >= 0) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			j--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsBlackNorthWest(int x, int y) {
		int i = x-1;
		int j = y-1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i >= 0 && j >= 0) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isWhite()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isBlack()) {
				tempCoords.add(new Coord(i, j));
			}
			i--;
			j--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	
	private static void checkScissorsWhiteNorth(int x, int y) {
		int i = x-1;
		int j = y;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i >= 0) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			i--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsWhiteNorthEast(int x, int y) {
		int i = x-1;
		int j = y+1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i >= 0 && j < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			i--;
			j++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsWhiteEast(int x, int y) {
		int i = x;
		int j = y+1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (j < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			j++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsWhiteSouthEast(int x, int y) {
		int i = x+1;
		int j = y+1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i < buttons.length && j < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			i++;
			j++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsWhiteSouth(int x, int y) {
		int i = x+1;
		int j = y;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			i++;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsWhiteSouthWest(int x, int y) {
		int i = x+1;
		int j = y-1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (j >= 0 && i < buttons.length) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			i++;
			j--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsWhiteWest(int x, int y) {
		int i = x;
		int j = y-1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (j >= 0) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			j--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	private static void checkScissorsWhiteNorthWest(int x, int y) {
		int i = x-1;
		int j = y-1;
		boolean valid = false;
		tempCoords = new LinkedList<Coord>();
		while (i >= 0 && j >= 0) {
			if (buttons[i][j].isEmpty()) {
				tempCoords = new LinkedList<Coord>();
				break;
			}
			if (buttons[i][j].isBlack()) {
				valid = true;
				break;
			}
			if (buttons[i][j].isWhite()) {
				tempCoords.add(new Coord(i, j));
			}
			i--;
			j--;
		}
		if (!tempCoords.isEmpty() && valid) {
			for (Coord c : tempCoords) {
				checkedCoords.add(c);
			}
		}
	}
	
	private static void checkScissorsBlackAllDirection(int x, int y) {
		//kozepso mezokbol
		if (x > 0 && y > 0 && x < buttons.length+1 && y < buttons.length+1) {
			checkScissorsBlackNorth(x, y);
			checkScissorsBlackNorthEast(x, y);
			checkScissorsBlackEast(x, y);
			checkScissorsBlackSouthEast(x, y);
			checkScissorsBlackSouth(x, y);
			checkScissorsBlackSouthWest(x, y);
			checkScissorsBlackWest(x, y);
			checkScissorsBlackNorthWest(x, y);
		}
		//balfolso sarokbol
		else if (x == 0 && y == 0) {
			checkScissorsBlackEast(x, y);
			checkScissorsBlackSouthEast(x, y);
			checkScissorsBlackSouth(x, y);
		}
		//folso savbol
		else if (x == 0 && y > 0 && y < buttons.length+1) {
			checkScissorsBlackEast(x, y);
			checkScissorsBlackSouthEast(x, y);
			checkScissorsBlackSouth(x, y);
			checkScissorsBlackSouthWest(x, y);
			checkScissorsBlackWest(x, y);
		}
		//jobb folso sarokbol
		else if (x == 0 && y == buttons.length+1) {
			checkScissorsBlackSouth(x, y);
			checkScissorsBlackSouthWest(x, y);
			checkScissorsBlackWest(x, y);
		}
		//jobb savbol
		else if (x > 0 && x < buttons.length+1 && y == buttons.length+1) {
			checkScissorsBlackNorth(x, y);
			checkScissorsBlackNorthWest(x, y);
			checkScissorsBlackWest(x, y);
			checkScissorsBlackSouthWest(x, y);
			checkScissorsBlackSouth(x, y);
		}
		//jobb also sarokbol
		else if (x == buttons.length+1 && y == buttons.length+1) {
			checkScissorsBlackNorth(x, y);
			checkScissorsBlackNorthWest(x, y);
			checkScissorsBlackWest(x, y);
		}
		//also savbol
		else if (x == buttons.length+1 && y > 0 && y < buttons.length+1) {
			checkScissorsBlackNorthEast(x, y);
			checkScissorsBlackEast(x, y);
			checkScissorsBlackNorth(x, y);
			checkScissorsBlackNorthWest(x, y);
			checkScissorsBlackWest(x, y);
		}
		//bal also sarokbol
		else if (x == buttons.length+1 && y == 0) {
			checkScissorsBlackNorth(x, y);
			checkScissorsBlackNorthEast(x, y);
			checkScissorsBlackEast(x, y);
		}
		//bal savbol
		else if (x > 0 && x < buttons.length+1 && y == 0) {
			checkScissorsBlackNorth(x, y);
			checkScissorsBlackNorthEast(x, y);
			checkScissorsBlackEast(x, y);
			checkScissorsBlackSouthEast(x, y);
			checkScissorsBlackSouth(x, y);
		}
		
	}
	public static void checkScissorsBlack(int x, int y) {
		checkedCoords.clear();
		
		if (buttons.length == GameField.getButtons().length) {
			checkScissorsBlackAllDirection(x, y);
		}
		for (Coord c : checkedCoords) {
			buttons[c.getX()][c.getY()].setIconWhite();
		}
	}
	
	private static void checkScissorsWhiteAllDirection(int x, int y) {
		//kozepso mezokbol
		if (x > 0 && y > 0 && x < buttons.length+1 && y < buttons.length+1) {
			checkScissorsWhiteNorth(x, y);
			checkScissorsWhiteNorthEast(x, y);
			checkScissorsWhiteEast(x, y);
			checkScissorsWhiteSouthEast(x, y);
			checkScissorsWhiteSouth(x, y);
			checkScissorsWhiteSouthWest(x, y);
			checkScissorsWhiteWest(x, y);
			checkScissorsWhiteNorthWest(x, y);
		}
		//balfolso sarokbol
		
		else if (x == 0 && y == 0) {
			checkScissorsWhiteEast(x, y);
			checkScissorsWhiteSouthEast(x, y);
			checkScissorsWhiteSouth(x, y);
		}
		//folso savbol
		else if (x == 0 && y > 0 && y < buttons.length+1) {
			checkScissorsWhiteEast(x, y);
			checkScissorsWhiteSouthEast(x, y);
			checkScissorsWhiteSouth(x, y);
			checkScissorsWhiteSouthWest(x, y);
			checkScissorsWhiteWest(x, y);
		}
		//jobb folso sarokbol
		else if (x == 0 && y == buttons.length+1) {
			checkScissorsWhiteSouth(x, y);
			checkScissorsWhiteSouthWest(x, y);
			checkScissorsWhiteWest(x, y);
		}
		//jobb savbol
		else if (x > 0 && x < buttons.length+1 && y == buttons.length+1) {
			checkScissorsWhiteNorth(x, y);
			checkScissorsWhiteNorthWest(x, y);
			checkScissorsWhiteWest(x, y);
			checkScissorsWhiteSouthWest(x, y);
			checkScissorsWhiteSouth(x, y);
		}
		//jobb also sarokbol
		else if (x == buttons.length+1 && y == buttons.length+1) {
			checkScissorsWhiteNorth(x, y);
			checkScissorsWhiteNorthWest(x, y);
			checkScissorsWhiteWest(x, y);
		}
		//also savbol
		else if (x == buttons.length+1 && y > 0 && y < buttons.length+1) {
			checkScissorsWhiteNorth(x, y);
			checkScissorsWhiteNorthWest(x, y);
			checkScissorsWhiteWest(x, y);
			checkScissorsWhiteNorthEast(x, y);
			checkScissorsWhiteEast(x, y);
		}
		//bal also sarokbol
		else if (x == buttons.length+1 && y == 0) {
			checkScissorsWhiteNorth(x, y);
			checkScissorsWhiteNorthEast(x, y);
			checkScissorsWhiteEast(x, y);
		}
		//bal savbol
		else if (x > 0 && x < buttons.length+1 && y == 0) {
			checkScissorsWhiteNorth(x, y);
			checkScissorsWhiteNorthEast(x, y);
			checkScissorsWhiteEast(x, y);
			checkScissorsWhiteSouthEast(x, y);
			checkScissorsWhiteSouth(x, y);
		}
	}
	public static void checkScissorsWhite(int x, int y) {
		checkedCoords.clear();
		if (buttons.length == GameField.getButtons().length) {
			checkScissorsWhiteAllDirection(x, y);
		}
		
		for (Coord c : checkedCoords) {
			buttons[c.getX()][c.getY()].setIconBlack();
		}
	}
	
	public static boolean isWhiteValid(int x, int y) {
		checkedCoords.clear();
		tempCoords.clear();
		
		if (buttons.length == GameField.getButtons().length) {
			if (!buttons[x][y].isEmpty()) {
				return false;
			}
			checkScissorsBlackAllDirection(x, y);
		}
		return !checkedCoords.isEmpty();
	}
	
	public static boolean isBlackValid(int x, int y) {
		checkedCoords.clear();
		tempCoords.clear();
		
		if (buttons.length == GameField.getButtons().length) {
			if (!buttons[x][y].isEmpty()) {
				return false;
			}
			checkScissorsWhiteAllDirection(x, y);
		}
		
		return !checkedCoords.isEmpty();
	}
}
