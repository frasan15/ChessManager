package gui;

import java.awt.FlowLayout;
import chess.*;
import javax.swing.*;



public class View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Model model;
	private Controller controller;
	private JTextArea contenuto;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	

	public View(Model model, Controller controller) {
		this.model = model;
		this.controller = controller;
		
		setTitle("gui");
		setSize(600,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JLabel x = new JLabel("posizione x: ");
		t1 = new JTextField(20);
		JLabel y = new JLabel("poszione y: ");
		t2 = new JTextField(20);
		
		
		JButton inserisci = new JButton("Ottieni pezzo ");
		JButton stampa = new JButton("Rimuovi pezzo ");
		contenuto = new JTextArea(50,30);
		inserisci.addActionListener(controller);
		stampa.addActionListener(controller);
		
		setLayout(new FlowLayout());
		
		add(x);
		add(t1);
		add(y);
		add(t2);
		add(inserisci);
		add(contenuto);
		add(stampa);
		
	}
	
	public void getPezzo() throws ChessException{
		String s = t1.getText();
		String s1 = t2.getText();
		Integer x = Integer.valueOf(s);
		Integer y = Integer.valueOf(s1);
		String s2 = model.stampaPezzo(x, y);
		contenuto.setText(s2);
	}
	
	public void removePezzo() throws ChessException {
		String s = t1.getText();
		String s1 = t2.getText();
		Integer x = Integer.valueOf(s);
		Integer y = Integer.valueOf(s1);
		String s2 = model.rimuovi(x,y);
		contenuto.setText(s2);
	}

}