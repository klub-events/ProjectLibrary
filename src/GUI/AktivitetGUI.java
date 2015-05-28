package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Domain.Control;
import GUI.MainGUI.TimeThread;
public class AktivitetGUI extends MainGUI implements ActionListener
{
	private JButton btn_opret = new JButton("OPRET");	
	
	private JButton btn_visAktiviteter = new JButton("VIS AKTIVITETER");
	
	public AktivitetGUI()
	{
		
		//JPanel Labels
		JPanel content1 = new JPanel(new GridLayout(10,1));
		
		//Navne ud for textfield
		String[] labelTekster = {"navn:", "pris:", "deltagerantal:", "dato:"};
		
		//adder navn og tekstfield til vinduet
		LabelTextfield navnBox = new LabelTextfield(labelTekster[0]);
		String navn = navnBox.getInputText();
		content1.add(navnBox);
		
		LabelTextfield prisBox = new LabelTextfield(labelTekster[1]);
		String pris = prisBox.getInputText();
		content1.add(prisBox);
		
		LabelTextfield deltagerantalBox = new LabelTextfield(labelTekster[2]);
		String deltagerantal = deltagerantalBox.getInputText();
		content1.add(deltagerantalBox);
		
		//speciel desginet dato api kommer
		LabelTextfield datoBox = new LabelTextfield(labelTekster[3]);
		String dato = datoBox.getInputText();
		content1.add(datoBox);
		
		
		
		Panel_Content.add(content1);
		content1.setBackground(Color.WHITE);
		btn_aktivitet.setBackground(Color.WHITE);
		
		btn_opret.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		content1.add(btn_opret);
		
		
		
		btn_visAktiviteter.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
		content1.add(btn_visAktiviteter);
	}//constructor slutter

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_opret)
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
		
	}//actionperformed sluter
	
}//public class medlem_GUI slutter


