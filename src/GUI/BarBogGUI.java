package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//For dan
public class BarBogGUI extends MainGUI implements ActionListener
{
	JButton btn_saldo = new JButton("SALDO");
	
	public BarBogGUI()
	{
		
		//JPanel Labels
		JPanel center = new JPanel(new GridLayout(10,1));
		
		//Navne ud for textfield
		String labelTekstSaldo = "Saldo";
		
		//adder navn og tekstfield til vinduet
		LabelTextfield navnBox = new LabelTextfield(labelTekstSaldo);
		center.add(navnBox);	
		
		Panel_Midt.add(center);
		center.setBackground(Color.WHITE);
		btn_aktivitet.setBackground(Color.WHITE);

		btn_saldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
		center.add(btn_saldo);
	}//constructor slutter
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			
			frame.dispose();
		}
		
		if(e.getSource() == btn_medlem )
	    {
		   new MedlemGUI();
	       frame.dispose();
	    }
		
		if(e.getSource() == btn_saldo){
			new BarBogGUI();
			
			frame.dispose();
		}
		
		if(e.getSource() == btn_aktivitet)
	    {
			new AktivitetGUI();
		
	       frame.dispose();
	    }
	}//actionperformed sluter
}//public class medlem_GUI slutter


