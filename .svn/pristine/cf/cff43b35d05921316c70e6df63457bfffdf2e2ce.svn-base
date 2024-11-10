package chess;
import java.util.*;
public class Board {
	
	private String name;
	private int dim;
	private Map<String, String> pezzi = new LinkedHashMap<>();
	
	public Board(String name, int dim) {
		this.name = name;
		this.dim = dim;
	}

	
	public void addPiece(String piece, int x, int y) throws ChessException{
		if(x>dim-1 || y>dim-1) throw new ChessException("Posizione non valida");
		String s = String.valueOf(x) + String.valueOf(y);
		if(piece == null) {
			if(pezzi.size()>0)
				for(String s1 : pezzi.keySet())
				if(s1.equals(s))
					pezzi.remove(s1);
			return;
		}
		pezzi.put(s, piece);
	}
	
	public String getPiece(int x, int y) throws ChessException {
		if(x>dim-1 || y>dim-1) throw new ChessException("Posizione non valida");
		String s = String.valueOf(x) + String.valueOf(y);
		return pezzi.get(s);
	}
	
	public int getSize() {
		//TODO
		return dim;
	}
	
	public String getName() {
		//TODO
		return name;
	}	
}
