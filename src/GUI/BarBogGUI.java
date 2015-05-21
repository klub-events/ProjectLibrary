package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Domain.Control;
import Domain.ControlBarbog;
//For dan
public class BarBogGUI extends MainGUI implements ActionListener
{
	JButton btn_visSaldo = new JButton("SALDO");
	JButton btn_redigerSaldo = new JButton("Gem");
	private LabelTextfield saldoBox;
	private String saldo;
	//command to get input from saldo-box
	//saldo = forNavnsaldo.getInputText();
	public BarBogGUI()
	{
		
		//JPanel Labels
		JPanel center3 = new JPanel(new GridLayout(10,1));
	
		//Navne ud for textfield
		String labelTekstSaldo = "Saldo";
		
		//adder navn og tekstfield til vinduet
		saldoBox = new LabelTextfield(labelTekstSaldo);
		center3.add(saldoBox);	
		
		Panel_Midt.add(center3);
		center3.setBackground(Color.WHITE);
		

		btn_visSaldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_visSaldo.addActionListener(this);
		
		btn_redigerSaldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_redigerSaldo.setToolTipText("Gemmer hvis oprettet medlem bliver redigeret");
		btn_redigerSaldo.addActionListener(this);
		
		center3.add(btn_redigerSaldo);
		center3.add(btn_visSaldo);
		center3.setBackground(Color.WHITE);
		btn_saldo.setBackground(Color.WHITE);
		
	}//constructor slutter
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_visSaldo)
		{	
			
			
			new Control().hentBarbogDB();
			//new TilmeldAktivitetGUI();
			
			frame.dispose();
		} 
		
		if(e.getSource() == btn_redigerSaldo )
	    {
		  // new BarBogGUI();
		   
		   saldo = (String) saldoBox.getInputText();
		   System.out.println("saldo be printed: " + saldo);
	     //  frame.dispose();
	    }
		if(e.getSource() == btn_aktivitet)
	    {
			new AktivitetGUI();
		
	       frame.dispose();
	    }
		
		if(e.getSource() == btn_medlem )
	    {
		   new MedlemGUI();
		
	       frame.dispose();
	    }
		
		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			
			frame.dispose();
		}
		
		
	}//actionperformed sluter
}//public class medlem_GUI slutter


