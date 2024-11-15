package gui;

import chess.Board;
import chess.ChessException;
import chess.Piece;

public class Client {
	
	public static void main(String[] args) {
		//this is an example, you can change it
		Board b = new Board("board", 5);
		try {
			b.addPiece(Piece.ROOK, 0, 0);
			b.addPiece(Piece.KING, 4, 4);
			b.addPiece(Piece.BISHOP, 2, 3);
			b.addPiece(Piece.PAWN, 3, 0);
		}
		catch (ChessException e) {
			System.out.println("Failed to initialize GUI");
			return;
		}		
		start(b);		
	}
	
	public static void start(Board b) {
		Model m = new Model (b);
		Controller c = new Controller(m);
		View v = new View(m,c);
		v.setVisible(true);
		c.setView(v);
	}
}
