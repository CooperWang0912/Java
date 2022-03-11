package chessLevel2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

public class Board {
	
	// keeps track of the position of each king. First row is the position of the white king, 
	// second row is the black king.
	private int[][] kingPositions = new int[2][2]; //Position of the two Kings

	// represents the entire board - make sure to initialize!.
	private Piece[][] board = new Piece[8][8]; //The board
	
	public Board() {
		
		// loads the images into a map
		HashMap<String, Image> images = loadImages(); //Load images
		
		
		board[4][7] = new King(1, images.get("BlackKing")); //Black King
		board[4][0] = new King(0, images.get("WhiteKing")); //White King
		kingPositions[0] = new int[]{4, 0}; //Black King position
		kingPositions[1] = new int[] {4, 7}; //White King position
		
		// fill in the rest of the chess board here

		for (int i = 0; i <= 7; i++){ //White Pawn Initialization
			board[i][1] = new Pawn(0, images.get("WhitePawn"));
		}

		for (int i = 0; i <= 7; i++){ //Black Pawn Initialization
			board[i][6] = new Pawn(1, images.get("BlackPawn"));
		}

		board[3][0] = new Queen(0, images.get("WhiteQueen")); //White Queen Initialization
		board[3][7] = new Queen(1, images.get("BlackQueen")); //Black Queen Initialization

		board[2][0] = new Bishop(0, images.get("WhiteBishop")); //White Bishop Initialization
		board[5][0] = new Bishop(0, images.get("WhiteBishop")); //White Bishop Initialization
		board[2][7] = new Bishop(1, images.get("BlackBishop")); //Black Bishop Initialization
		board[5][7] = new Bishop(1, images.get("BlackBishop")); //Black Bishop Initialization

		board[1][0] = new Knight(0, images.get("WhiteKnight")); //White Knight Initialization
		board[6][0] = new Knight(0, images.get("WhiteKnight")); //White Knight Initialization
		board[1][7] = new Knight(1, images.get("BlackKnight")); //Black Knight Initialization
		board[6][7] = new Knight(1, images.get("BlackKnight")); //Black Knight Initialization

		board[0][0] = new Rook(0, images.get("WhiteRook")); //White Rook Initialization
		board[7][0] = new Rook(0, images.get("WhiteRook")); //White Rook Initialization
		board[0][7] = new Rook(1, images.get("BlackRook")); //Black Rook Initialization
		board[7][7] = new Rook(1, images.get("BlackRook")); //Black Rook Initialization

		for (int i = 0; i <= 7; i++){
			for (int j = 0; j <= 7; j++){
				if (board[i][j] == null){ //Checking for blanks
					board[i][j] = new Empty(); //Replace blanks with empty class
				}
			}
		}
	}
	
	// draws the board. There should be a grid of 8x8 squares, and each piece in their location. 
	// the last clicked piece (curr) should be drawn on a yellow background.
	public void draw(Graphics g, Piece curr) {

		g.setColor(Color.WHITE); //Set the color to white
		g.fillRect(0, 0, Chess.WIDTH, Chess.WIDTH);
		int sw = Chess.SQUARE_WIDTH; // the width of each square on the board
		g.setColor(Color.black); //Set the color to black
		for (int i = 1; i <= 8; i++) {
			g.drawLine(0, Chess.WIDTH / 8 * i, Chess.WIDTH, Chess.WIDTH / 8 * i); //Draws the horizontal lines
		}
		for (int i = 1; i <= 8; i++) {
			g.drawLine(Chess.WIDTH / 8 * i, 0, Chess.WIDTH / 8 * i, Chess.WIDTH); //Draws the vertical lines
		}
		boolean green = true; //Boolean for coloring
		for (int i = 0; i <= 7; i++) { //Go through the board
			for (int j = 0; j <= 7; j++){ //Go through the board
				if (green == true && j != 7){ //If the color is true and not the end of the row
					g.setColor(new Color(0,100,0)); //Set the color
					g.fillRect(Chess.WIDTH / 8 * j, Chess.WIDTH / 8 * i, Chess.WIDTH / 8, Chess.WIDTH / 8); //Fill in color
					green = false; //Color boolean equals to false
				}
				else if (green == true && j == 7){ //If the color boolean is true and the end of the row
					g.setColor(new Color(0,100,0)); //Set the color
					g.fillRect(Chess.WIDTH / 8 * j, Chess.WIDTH / 8 * i, Chess.WIDTH / 8, Chess.WIDTH / 8); //Fill in color
				}
				else if (green == false && j != 7){ //If the color boolean is false and not the end of the row
					green = true; //Color boolean equals to false
				}
			}
		}
		for (int i = 0; i <= 7; i++){
			for (int j = 0; j <= 7; j++){
				if (board[i][j] == curr){ //If the piece is the current piece
					g.setColor(Color.YELLOW); //Set the color to yellow
					g.fillRect(Chess.WIDTH / 8 * j, Chess.WIDTH / 8 * i, Chess.WIDTH / 8, Chess.WIDTH / 8); //Fill the block with yellow
				}
				if (board[i][j].isEmpty() == false){ //If the block is not empty
					board[i][j].draw(g, Chess.WIDTH / 8 * j, Chess.WIDTH / 8 * i); //draw the piece
				}
				if (board[i][j] == curr) { //If the piece is the current piece
					g.setColor(Color.red); //Set the color to red
					for (int k = 0; k <= board[i][j].getMoves(this, i, j).size() - 1; k++) { //Go through the possible moves
						g.fillOval(board[i][j].getMoves(this, i, j).get(k)[1] * 600 / 8 + 600 / 16 - 15, board[i][j].getMoves(this, i, j).get(k)[0] * 600 / 8 + 600 / 16 - 15, 30, 30); //Use red dots to label possible moves
					}
				}
			}
		}
	}
	
	// moves the piece currently at (r, c) to (newR, newC), filling 
	// in the vacated space with an empty square.
	// returns 0 for a normal move, 1 for a check move, 2 for a checkmate move
	public int move(int r, int c, int newR, int newC) {
		if (board[r][c].getClass() == King.class){ //If the piece is King
			kingPositions[(board[r][c].getTeam())] = new int[]{newR, newC}; //Change the King position
		}
		board[newR][newC] = board[r][c]; //Move the piece to the new square
		board[r][c] = new Empty(); //
		if (check()){ //Check if the move is a check move
			return 1; //Returns check
		}
		if (checkmate()){ //Check if the move is a checkmate move
			return 2; //Returns checkmate
		}
		else{ //Check if the move is a normal move
			return 0; //Returns normal
		}
	}
	
	// determines if the non-current team is in check.
	public boolean check() {
		boolean id = false; //Declare the return variable
		for (int i = 0; i <= 7; i++){
			for (int j = 0; j <= 7; j++){
				if (board[i][j].getTeam() == 0){ //If the team is white
					if (board[i][j].check(kingPositions[1][0], kingPositions[1][1], i, j, this)) { //Use the check method in the piece class
						return true; //Return true if true
					} else {
						id = false; //Return false if false
					}
				}
				if (board[i][j].getTeam() == 1) { //If the team is black
					if (board[i][j].check(kingPositions[0][0], kingPositions[0][1], i, j, this)) { //Use the check method in the piece class
						return true; //Return true if true
					} else {
						id = false; //Return false if false
					}
				}
			}
		}
		return id; //Return the variable
	}

	// Determines if the move is a checkmate move
	public boolean checkmate(){
		boolean whiteId = false; //Define White King status as false
		boolean blackId = false; //Define Black King status as false
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (board[i][j].getClass() == King.class && board[i][j].getTeam() == 0){ //If White King exists
					whiteId = true; //White King status equals to true
				}
				if (board[i][j].getClass() == King.class && board[i][j].getTeam() == 1){ //If Black King exists
					blackId = true; //Black King status equals to true
				}
			}
		}
		if (whiteId == true && blackId == true){ //If both are true, it is not a checkmate move
			return false; //Return not checkmate
		}
		else{ //If one is false, it is a checkmate move
			return true; //Return checkmate
		}
	}


	
	
	/******** DON'T TOUCH THE BELOW CODE ****************/
	
	// loads all necessary images into a map. Key = piece name, value = corresponding image
	public HashMap<String, Image> loadImages() {
		String[] pieces = {"King", "Queen", "Rook", "Bishop", "Knight", "Pawn"};
		
		HashMap<String, Image> images = new HashMap<String, Image>();
		
		for (String p : pieces) {
			for (String color : new String[] {"Black", "White"}) {
				Image img = Toolkit.getDefaultToolkit().getImage("Images/" + color + p + ".png");	
				images.put(color + p, img.getScaledInstance(Chess.IMG_WIDTH, Chess.IMG_WIDTH, Image.SCALE_SMOOTH));
			}
		}
		return images;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
}
