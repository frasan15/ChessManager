package gui;

import chess.*;

public class Model {
	
	private Board b;

	public Model(Board b) {
		this.b = b;
	}
	

	
	public String stampaPezzo(int x, int y) throws ChessException {
		String s1 = "";
		try {
		s1 = b.getPiece(x, y);
		}catch(ChessException e1) {
			s1 = "posizione non valida";
		}
		
		return s1;
	}
	
	public String rimuovi(int x, int y) throws ChessException{
		String s1 = "";
		try {
			String s3 = new String();
		b.addPiece(s3, x, y);
		s1 = "Pezzo rimosso";
		}catch (ChessException e1) {
			s1 = "posizione non valida";
		}
		return s1;
	}
	}
