package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Domain.*;

public class MedlemGUI extends MainGUI implements ActionListener
{
	private JButton btn_opretMedlem = new JButton("OPRET");
	private JButton btn_redigerMedlem = new JButton("GEM");
	private JButton btn_visMember = new JButton("VIS MEMBER");
	
	//Værdier for indtastede oplysnigner
	private String fornavn;
	private String efternavn;
	private String adresse;
	private int foedselsdato;
	private int telefon;
	private String email;
	private String navnDoer;
	private int billeder;
		
	//Text-label fields created
	private LabelTextfield forNavnBox;
	private LabelTextfield efterNavnBox;
	private LabelTextfield adresseBox;
	private LabelTextfield foedselsdatoBox;
	private LabelTextfield telefonBox;
	private LabelTextfield emailBox;
	private LabelTextfield navnDoerBox;
	
	
	private JComboBox billedeValg;
	private String[] comboValg = {"Nej","Ja"};
	
	public MedlemGUI(){
		  
				//JPanel Labels
				JPanel center2 = new JPanel(new GridLayout(11,1));
				
				//Navne ud for textfield
				String[] labelTekster = {"fornavn:","efternavn", "adresse:", "foedselsdato:", "telefon:", "email", "navn på doer:", "billeder"};
				
				//adder navn og tekstfield til vinduet
				forNavnBox = new LabelTextfield(labelTekster[0]);
				center2.add(forNavnBox);
				
				//adder navn og tekstfield til vinduet
				 efterNavnBox = new LabelTextfield(labelTekster[1]);
				center2.add(efterNavnBox);
				
				adresseBox = new LabelTextfield(labelTekster[2]);
				center2.add(adresseBox);
				
				//dato api
				foedselsdatoBox = new LabelTextfield(labelTekster[3]);
				center2.add(foedselsdatoBox);
				
				telefonBox = new LabelTextfield(labelTekster[4]);
				center2.add(telefonBox);
				
				emailBox = new LabelTextfield(labelTekster[5]);
				center2.add(emailBox);
				
				navnDoerBox = new LabelTextfield(labelTekster[6]);
				center2.add(navnDoerBox);
				
				
				//skal have label foran som de andre :S
				billedeValg = new JComboBox(comboValg);
				billedeValg.setSelectedIndex(0);
				//billedeValg.setLayout(new GridLayout(1, 1));
				
				center2.add(billedeValg);				
				
				Panel_Midt.add(center2);
				center2.setBackground(Color.WHITE);		
		
		
		
		  btn_medlem.setBackground(Color.white);	
		  
		  
		  btn_opretMedlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		  btn_opretMedlem.addActionListener(this);
		  center2.add(btn_opretMedlem);
		  
		  btn_redigerMedlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		  btn_redigerMedlem.setToolTipText("Gemmer hvis oprettet medlem bliver redigeret");
		  btn_redigerMedlem.addActionListener(this);
		  center2.add(btn_redigerMedlem);
		  
		  
		  
		  
		  btn_visMember.setCursor(new Cursor(Cursor.HAND_CURSOR));
		  btn_visMember.addActionListener(this);
		 
		  center2.add(btn_visMember);
		  
		  
		
	}//constructor slutter	
	public void actionPerformed(ActionEvent e)
	{	  
		if(e.getSource() == btn_opretMedlem){
			fornavn = forNavnBox.getInputText();
			efternavn = efterNavnBox.getInputText();
			adresse = adresseBox.getInputText();
			foedselsdato = Integer.parseInt(foedselsdatoBox.getInputText());
			telefon = Integer.parseInt(telefonBox.getInputText());
			email = emailBox.getInputText();
			navnDoer = navnDoerBox.getInputText();
			if(billedeValg.getSelectedItem()== "Ja"){
				billeder = 1;
			}
			else{
				billeder = 0;
			}
			Medlem m = new Medlem (0, fornavn, efternavn, adresse, foedselsdato, telefon, email, navnDoer, billeder);
			System.out.println(m.toString());
			new Control().opretMedlem(m);
		}
		
		if(e.getSource() == btn_aktivitet)
	    {
			new AktivitetGUI();
		
	       frame.dispose();
	    }
		
		if(e.getSource() == btn_saldo){
			new BarBogGUI();
			
			frame.dispose();
		}
		
		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			
			frame.dispose();
		}
		
		if(e.getSource() == btn_visMember) 
		{
			new MedlemTabel();
	    }
		
	}//actionPerformed slutter
}//public class medlem_GUI slutter
