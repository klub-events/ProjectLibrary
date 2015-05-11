package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Domain.Control;
import Domain.Program;



public class MedlemGUI extends MainGUI implements ActionListener
{
	JButton btm_opretMedlem = new JButton();
	JButton btn_visMember = new JButton();
	
	public MedlemGUI(){
		  btn_medlem.setBackground(Color.white);	
		  btn_visMember.addActionListener(this);
		  Panel_Midt.add(btn_visMember);
		
	}//constructor slutter
	
	public void actionPerformed(ActionEvent e){	  
		
		
		if(e.getSource() == btn_visMember) 
		{
			
			
	    }
		
		if(e.getSource() == btn_visMember) 
		{
			System.out.println("vis member clicked");
			Control.startTabel();  
	    }
	}
}//public class medlem_GUI slutter
