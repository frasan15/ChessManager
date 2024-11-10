package chess;
import java.util.*;

public class Torneo {
	
	private String name;
	private Map<Player, Integer> punteggi;
	
	public Torneo(String name) {
		this.name = name;
		punteggi = new HashMap<>();
	}
	
	public void addP(Player p, Integer i) {
		p.setP(i);
		punteggi.put(p, i);
	}
	
	public int g() {
		return punteggi.size();
	}
	
	public String best() {
		String s = "";
		int i = 0;
		for(Player p : punteggi.keySet()) {
			if(p.getP()>i) {
				i = p.getP();
				s = p.getName() + ":" + i;
			}
		}
		return s;
	}

}
