package chess;

import java.util.*;

public class ChessManager {
	
	private Map<String, Board> scacchi = new HashMap<>();
	private Map<String, Player> player = new HashMap<>();
	private Map<String, Torneo> tornei = new HashMap<>();
	
	public void addBoard(Board b) {
		scacchi.put(b.getName(), b);
	}
	
	public Board getBoard(String boardName) {
		
		return scacchi.get(boardName);
	}
	
	public void addPlayer(Player p) {
		player.put(p.getName(), p);
	}
	
	public Player getPlayer(String playerName) {
		return player.get(playerName);
	}
	
	public void addPlayerToBoard(String playerName, String boardName) {
		Player p = player.get(playerName);
		Board b = scacchi.get(boardName);
		p.addBoard(b);
		player.put(playerName, p);
	}
	
	public Collection<Board> getBoardsOfPlayer(String playerName) {
		Player p = player.get(playerName);
		return p.getBoard();
	}
	
	public void createTournament(String tournamentName) throws ChessException {
		if(tornei.containsKey(tournamentName)) throw new ChessException("Torneo gia esistente");
		Torneo t = new Torneo(tournamentName);
		tornei.put(tournamentName, t);
	}
	
	public void addPlayerToTournament(String tournamentName, String playerName, Integer score) throws ChessException{
		if(!player.containsKey(playerName)) throw new ChessException("giocatore non presente");
		Torneo t = tornei.get(tournamentName);
		Player p = player.get(playerName);
		t.addP(p, score);
	}
	
	public String getLeadingPlayer(String tournamentName) {
		Torneo t = tornei.get(tournamentName);
		if(t.g() == 0) return null;
		return t.best();
	}
	
	public Board fillQueens(String boardName, Integer boardSize) {
		Board b = new Board(boardName, boardSize);
		try { resolveQueens(b,0);
		} catch (ChessException e) {
			e.printStackTrace();
		}return b;
	}
	public boolean resolveQueens(Board b, int col) throws ChessException {
		if(col >= b.getSize()) return true;
		for(int i=0; i<b.getSize();i++) {
			if(checkQueen(b,i,col)) { b.addPiece(Piece.QUEEN, i, col);
				if(resolveQueens(b,col+1) == true) return true;
				b.addPiece(null, i, col);
			}
		}return false; }
	
	//DO NOT CHANGE
	private boolean checkQueen(Board board, int x, int y) throws ChessException {
		if(board.getPiece(x, y) != null) {
			return false;
		}		
		//rows and columns
		for(int i = 0; i < board.getSize(); ++i) {
			if((board.getPiece(x,i)!=null && board.getPiece(x,i).equals(Piece.QUEEN)) || (board.getPiece(i,y) != null && board.getPiece(i,y).equals(Piece.QUEEN))) {
				return false;
			}
		}
		//diagonals
		for(int i = 0; i < board.getSize(); ++i) {			
			if((x+i) < board.getSize() && (y+i) < board.getSize() && (board.getPiece(x+i,y+i) != null && board.getPiece(x+i,y+i).equals(Piece.QUEEN))) {
				return false;
			}
			if((x+i) < board.getSize() && (y-i) >= 0 && (board.getPiece(x+i,y-i) != null && board.getPiece(x+i,y-i).equals(Piece.QUEEN))) {
				return false;
			}
			if((x-i) >= 0 && (y+i) < board.getSize() && (board.getPiece(x-i,y+i) != null && board.getPiece(x-i,y+i).equals(Piece.QUEEN))) {
				return false;
			}
			if((x-i) >= 0 && (y-i) >= 0 && (board.getPiece(x-i,y-i) != null && board.getPiece(x-i,y-i).equals(Piece.QUEEN))) {
				return false;
			}
		}
		return true;
	}	
}
