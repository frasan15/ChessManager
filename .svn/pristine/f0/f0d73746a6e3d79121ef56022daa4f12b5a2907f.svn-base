package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import chess.*;


public class Controller implements ActionListener{
	
	private Model model;
	private View view;
	
	public Controller (Model model) {
		this.model = model;
	}
	
	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o instanceof JButton) {
		String s = "Ottieni pezzo ";
		String s1 = "Rimuovi pezzo ";
		String s2 = e.getActionCommand();
		if(s2.equals(s)) {
			try {
				view.getPezzo();
			} catch (ChessException e1) {
				e1.printStackTrace();
			}
		}if(s2.equals(s1)) {
			try {
				view.removePezzo();
			}catch(ChessException hh) {
				hh.printStackTrace();
			}
		}
			
		}
	}

}