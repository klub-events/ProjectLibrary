package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import Domain.Control;
import Domain.Program;
import GUI.AktivitetGUI;
import GUI.MainGUI;



public class MedlemGUI extends MainGUI implements ActionListener
{
	private JButton btn_opretMedlem = new JButton("opret medlem");
	private JButton btn_visMember = new JButton("vis member");

	
	public MedlemGUI()
	{
		  btn_medlem.setBackground(Color.white);	
		  
		  Panel_Midt.add(btn_visMember);
		  btn_visMember.addActionListener(this);
		  
		  Panel_Midt.add(btn_opretMedlem);
		  btn_opretMedlem.addActionListener(this);
		
	}//constructor slutter
	
	public void actionPerformed(ActionEvent e)
	{	  
		
		if(e.getSource() == btn_aktivitet)
	    {
			new AktivitetGUI();
		
	       frame.dispose();
	    }
		
		if(e.getSource() == btn_visMember) 
		{
			
			
	    }
		
		if(e.getSource() == btn_visMember) 
		{
			System.out.println("vis member clicked");
			Control.startTabel();  
	    }
	}//actionPerformed slutter
}//public class medlem_GUI slutter
