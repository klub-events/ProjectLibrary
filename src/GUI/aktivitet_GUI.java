package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class aktivitet_GUI extends MainGUI
{
	
	JButton btn_gem = new JButton();
	JTextField txt_fornavn = new JTextField(20);
	JTextField txt_efternavn = new JTextField(20);
	JTextField txt_adresse = new JTextField(20);
	JTextField txt_tlf = new JTextField(20);
	JLabel label = new JLabel("Hello world!");
	
	public aktivitet_GUI()
	{
		
		//JPanel Labels
		JPanel center = new JPanel(new GridLayout(10,1));
		//JPanel center = new JPanel(new BoxLayout(null, 0));
		String[] labelTekster = {"Fornavn:", "Efternavn:", "Adresse:", "Telefon:"};
		LabelTextfield fornavnsBox = new LabelTextfield(labelTekster[0]);
		String fornavn = fornavnsBox.getInputText();
	
		center.add(fornavnsBox);
		//add panels to frame
		//Panel_Midt.add(Labels, BorderLayout.WEST);
		//Panel_Midt.add(textFields, BorderLayout.CENTER);
		// Panel_Midt.getContentPane().add(center, "West");
		Panel_Midt.add(center);
		 center.setBackground(Color.darkGray);
		
		
		
		
		
		
	
		
		  btn_aktivitet.setBackground(Color.GRAY);
		 btn_gem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}//constructor slutter
	
	
}//public class medlem_GUI slutter


