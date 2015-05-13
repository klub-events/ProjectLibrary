package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Domain.Control;
import Domain.Program;
import GUI.AktivitetGUI;
import GUI.MainGUI;



public class MedlemGUI extends MainGUI implements ActionListener
{
	private JButton btn_opretMedlem = new JButton("GEM");
	private JButton btn_visMember = new JButton("VIS MEMBER");
	

	
	public MedlemGUI()
	{
		  
		//JPanel Labels
				JPanel center2 = new JPanel(new GridLayout(10,1));
				
				//Navne ud for textfield
				String[] labelTekster = {"navn:", "adresse:", "foedselsdato:", "telefon:", "email", "navn på doer:", "billeder"};
				
				//adder navn og tekstfield til vinduet
				LabelTextfield navnBox = new LabelTextfield(labelTekster[0]);
				String navn = navnBox.getInputText();
				center2.add(navnBox);
				
				LabelTextfield adresseBox = new LabelTextfield(labelTekster[1]);
				String adresse = adresseBox.getInputText();
				center2.add(adresseBox);
				
				//dato api
				LabelTextfield foedselsdatoBox = new LabelTextfield(labelTekster[2]);
				String foedselsdato = foedselsdatoBox.getInputText();
				center2.add(foedselsdatoBox);
				
				
				LabelTextfield telefonBox = new LabelTextfield(labelTekster[3]);
				String telefon = telefonBox.getInputText();
				center2.add(telefonBox);
				
				LabelTextfield emailBox = new LabelTextfield(labelTekster[4]);
				String email = emailBox.getInputText();
				center2.add(emailBox);
				
				LabelTextfield navnDoerBox = new LabelTextfield(labelTekster[5]);
				String navnDoer = navnDoerBox.getInputText();
				center2.add(navnDoerBox);
				
				//billed upload ??
				LabelTextfield billederBox = new LabelTextfield(labelTekster[6]);
				String billeder = billederBox.getInputText();
				center2.add(billederBox);
				
				
				
				Panel_Midt.add(center2);
				center2.setBackground(Color.WHITE);		
		
		
		
		  btn_medlem.setBackground(Color.white);	
		  
		  
		  btn_opretMedlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		  btn_opretMedlem.addActionListener(this);
		  center2.add(btn_opretMedlem);
		  
		  
		  btn_visMember.setCursor(new Cursor(Cursor.HAND_CURSOR));
		  btn_visMember.addActionListener(this);
		  center2.add(btn_visMember);
		  
		  
		
	}//constructor slutter
	
	public void actionPerformed(ActionEvent e)
	{	  
		
		if(e.getSource() == btn_aktivitet)
	    {
			new AktivitetGUI();
		
	       frame.dispose();
	    }
		
		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			
			frame.dispose();
		}
		
		if(e.getSource() == btn_visMember) 
		{
			System.out.println("vis member clicked");
			Control.startTabel();  
	    }
	}//actionPerformed slutter
}//public class medlem_GUI slutter
