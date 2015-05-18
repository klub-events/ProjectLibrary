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
	JButton btn_saldo = new JButton("SALDO");
	JButton btn_redigerSaldo = new JButton("Gem");
	private LabelTextfield saldoBox;
	private String saldo;
	//command to get input from saldo-box
	//saldo = forNavnsaldo.getInputText();
	public BarBogGUI()
	{
		
		//JPanel Labels
		JPanel center = new JPanel(new GridLayout(10,1));
		JPanel center2= new JPanel (new GridLayout (20,2));
		//Navne ud for textfield
		String labelTekstSaldo = "Saldo";
		
		//adder navn og tekstfield til vinduet
		saldoBox = new LabelTextfield(labelTekstSaldo);
		center.add(saldoBox);	
		
		Panel_Midt.add(center);
		center.setBackground(Color.WHITE);
		btn_aktivitet.setBackground(Color.WHITE);

		btn_saldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_saldo.addActionListener(this);
		
		Panel_Midt.add(center2);
		center.setBackground(Color.WHITE);
		btn_aktivitet.setBackground(Color.WHITE);
		
		btn_redigerSaldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_redigerSaldo.setToolTipText("Gemmer hvis oprettet medlem bliver redigeret");
		btn_redigerSaldo.addActionListener(this);
		center2.add(btn_redigerSaldo);
		center.add(btn_saldo);
	}//constructor slutter
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_saldo)
		{	
			new BarBogGUI();
			System.out.println("vis barbog clicked");
			new ControlBarbog().startTabel();
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
		
		if(e.getSource() == btn_tilmeld){
			new BarBogGUI();
			System.out.println("vis member clicked");
			new Control().startTabel();
			frame.dispose();
		}
		
		if(e.getSource() == btn_aktivitet)
	    {
			new AktivitetGUI();
		
	       frame.dispose();
	    }
	}//actionperformed sluter
}//public class medlem_GUI slutter


