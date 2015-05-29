package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Domain.*;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AktivitetGUI extends MainGUI implements ActionListener
{
	private JButton btn_opret = new JButton("OPRET");	
	
	private JButton btn_visAktiviteter = new JButton("VIS AKTIVITETER");

	private String navn;

	private String pris;

	private String antal;

	private String dato;

	private LabelTextfield navnBox;

	private LabelTextfield prisBox;

	private LabelTextfield deltagerantalBox;

	private LabelTextfield datoBox;
	
	public AktivitetGUI()
	{
		
		//JPanel Labels
		JPanel content1 = new JPanel(new GridLayout(10,1));
		
		//Navne ud for textfield
		String[] labelTekster = {"navn:", "pris:", "deltagerantal:", "dato:"};
		
		//adder navn og tekstfield til vinduet
		this.navnBox = new LabelTextfield(labelTekster[0]);
		String navn = navnBox.getInputText();
		content1.add(navnBox);
		
		this.prisBox = new LabelTextfield(labelTekster[1]);
		String pris = prisBox.getInputText();
		content1.add(prisBox);
		
		this.deltagerantalBox = new LabelTextfield(labelTekster[2]);
		String deltagerantal = deltagerantalBox.getInputText();
		content1.add(deltagerantalBox);
		
		//speciel desginet dato api kommer
		this.datoBox = new LabelTextfield(labelTekster[3]);
		String dato = datoBox.getInputText();
		content1.add(datoBox);
		
		
		
		Panel_Content.add(content1);
		content1.setBackground(Color.WHITE);
		btn_aktivitet.setBackground(Color.GRAY);
		
		btn_opret.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_opret.addActionListener(this);
		content1.add(btn_opret);
		
		
		
		btn_visAktiviteter.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
		content1.add(btn_visAktiviteter);
	}//constructor slutter

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_opret)
		{
			
			navn = navnBox.getInputText();
			pris = prisBox.getInputText();
			antal = deltagerantalBox.getInputText();
			dato = datoBox.getInputText();
			
			
			try{
				
				
				Aktivitet aktivitet = new Aktivitet(0, navn, pris, antal, dato);
				new Control().opretAktivitet(aktivitet);
//				JOptionPane.showMessageDialog(frame,"Aktivitet oprettet!");


			}catch(Exception e1){
				JOptionPane.showMessageDialog(frame,"Et eller flere felter er ikke blevet udfyldt. Udfyld alle felter, og prøv igen.");
			}
									
						
			
			new AktivitetGUI();
			
			frame.dispose();
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
		if(e.getSource() == btn_saldo){
			new SaldoGUI();
			frame.dispose();
		}
		
	}//actionperformed sluter
	
}//public class medlem_GUI slutter


