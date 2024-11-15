package main;

import java.util.Collection;

import chess.Board;
import chess.ChessException;
import chess.ChessManager;
import chess.Piece;
import chess.Player;

public class ExampleMain {	
	public static void main(String args[]) {
		
		//R1
		System.out.println("-------------- R1 ---------------");
		Board b1 = new Board("b1", 5);
		try {
			b1.addPiece(Piece.ROOK, 0, 0);
			b1.addPiece(Piece.KING, 4, 4);
			b1.addPiece(Piece.BISHOP, 2, 3);
			b1.addPiece(Piece.PAWN, 3, 0);
			System.out.println(b1.getName());	//b1
			System.out.println(b1.getSize());	//5
			System.out.println(b1.getPiece(0, 0)); //ROOK
			System.out.println(b1.getPiece(4, 4)); //KING
			System.out.println(b1.getPiece(2, 3)); //BISHOP
			System.out.println(b1.getPiece(3, 0)); //PAWN
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			b1.addPiece(Piece.ROOK, 5, 5);
			System.err.println("Undetected wrong insert position");
		}
		catch (ChessException e) {
			//Exception correctly identified
			System.out.println("Exception corrently identified");
		}
		
		try {
			b1.getPiece(5, 5);
			System.err.println("Undetected wrong lookup position");
		}
		catch (ChessException e) {
			//Exception correctly identified
			System.out.println("Exception corrently identified");
		}
		
		//R2
		System.out.println("-------------- R2 ---------------");
		ChessManager mg = new ChessManager();
		
		mg.addBoard(new Board("b2", 2));
		mg.addBoard(new Board("b3", 3));
		mg.addBoard(new Board("b4", 4));
		Board out = mg.getBoard("b2");
		System.out.println(out != null ? out.getName(): out); //b2
	
		
		mg.addPlayer(new Player("Edoardo", "Italian", 29));
		System.out.println(mg.getPlayer("Edoardo")); //Edoardo,Italian,29
		
		mg.addPlayerToBoard("Edoardo", "b2");
		mg.addPlayerToBoard("Edoardo", "b4");
		Collection boards = mg.getBoardsOfPlayer("Edoardo");
		if(boards != null) {
			for(Board b : mg.getBoardsOfPlayer("Edoardo")) {
				System.out.println(b.getName()); //b2 b4
			}
		}
		else {
			System.out.println(boards);
		}
		
		
		//R3
		System.out.println("-------------- R3 ---------------");
		mg.addPlayer(new Player("Gustavo", "Colombian", 35));
		mg.addPlayer(new Player("Pietro", "Italian", 24));
		
		try {
			mg.createTournament("Regionali Torino");
			mg.createTournament("Nazionali Roma");
			mg.addPlayerToTournament("Regionali Torino", "Edoardo", 33);
			mg.addPlayerToTournament("Regionali Torino", "Gustavo", 55);
			mg.addPlayerToTournament("Regionali Torino", "Pietro", 11);
			System.out.println(mg.getLeadingPlayer("Regionali Torino")); //Gustavo:55
			System.out.println(mg.getLeadingPlayer("Nazionali Roma")); //null
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			mg.createTournament("Nazionali Roma");
			System.err.println("Failed to detect duplicated tournament");
		}
		catch (ChessException e){
			//Duplicated tournament correctly identified
			System.out.println("Duplicated tournament correctly identified");
		}
		
		try {
			mg.addPlayerToTournament("Nazionali Roma", "Filippo", 99);
			System.err.println("Failed to detect non existent player");
		}
		catch (ChessException e){
			//Non existent player correctly detected
			System.out.println("Non existent player correctly detected");
		}
		
		//R5
		System.out.println("-------------- R5 ---------------");
		printBoard(mg.fillQueens("bq", 12)); //(controllare correttezza)
	}
	
	
	//FUNZIONE DI SUPPORTO PER STAMPARE BOARD A SCHERMO
	public static void printBoard(Board b) {
		if (b == null) {
			System.out.println(b);
			return;
		}
		try {
			for(int i = 0; i < b.getSize(); ++i) {
				for(int j = 0; j < b.getSize(); ++j) {
					System.out.print(String.format("%-7s", b.getPiece(i, j)));				
				}
				System.out.println("");
			}
		}
		catch (Exception e){
			System.err.println(e.getMessage());
		}
	}		
}


