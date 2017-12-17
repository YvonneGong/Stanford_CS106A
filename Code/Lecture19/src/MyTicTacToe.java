/* File: MyTicTacToe.java
 * -------------------
 * This program uses 2D arrays to play the game "Tic-Tac-Toe".
 * -------------------
 */

import acm.program.*;
import java.util.*;

public class MyTicTacToe extends ConsoleProgram {
	
	private static final char EMPTY = ' ';
	
	public void run() {
		// Step 1: create and initialize board
		int size = readInt("Enter board size: ");
		char[][] board = createBoard(size);
		board[0][0] = 'X';
		board[1][1] = 'O';
		
		// Step 2: print out the board to the screen
		printBoard(board);
		
		// Step 3: Play a single turn
		playTurn(board, 'X');
	}
	
	private void playTurn(char[][] board, char player) {
		// Step a) get a location
		int row = -1;
		int col = -1;
		while (row == -1 && col == -1) {
			String line = readLine("Move (" + player + "): ");
			Scanner s = new Scanner(line);
			int enteredRow = s.nextInt();
			int enteredCol = s.nextInt();
			
			if (board[enteredRow][enteredCol] == EMPTY) {
				row = enteredRow;
				col = enteredCol;
			} else {
				println("That space is already taken!");
			}
		}
		
		// Step b) update our board
		board[row][col] = player;
		printBoard(board);
	}
	
	private char[][] createBoard(int size) {
		char[][] board = new char[size][size];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = EMPTY;
			}
		}
		
		return board;
	}
	
	private void printBoard(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			printRow(board[r]);
		}
	}
	
	private void printRow(char[] row) {
		print(" " + row[0] + " ");
		for (int c = 1; c < row.length; c++) {
			print("| " + row[c] + " ");
		}
		println();
	}
}
