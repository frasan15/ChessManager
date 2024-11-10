package chess;
import java.util.*;

public class Player {
	
	private String name;
	private String nat;
	private int age;
	private Integer p = 0;
	private List<Board> board;
	
	public Player(String name, String nat, int age) {
		this.name = name;
		this.nat = nat;
		this.age = age;
		board = new LinkedList<>();
	}
	
	@Override
	public String toString() {
		return name + "," + nat + "," + age;
	}
	
	public String getName() {
		return name;
	}
	
	public void addBoard(Board b) {
		board.add(b);
	}
	
	public Collection<Board> getBoard(){
		return board;
	}
	
	public void setP(Integer i) {
		p = i;
	}
	
	public Integer getP() {
		return p;
	}
}
