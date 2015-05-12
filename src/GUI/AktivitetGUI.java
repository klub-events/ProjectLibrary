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
//For dan
public class AktivitetGUI extends MainGUI
{
	
	JButton btn_gem = new JButton();
	JTextField txt_fornavn = new JTextField(20);
	JTextField txt_efternavn = new JTextField(20);
	JTextField txt_adresse = new JTextField(20);
	JTextField txt_tlf = new JTextField(20);
	JLabel label = new JLabel("Hello world!");
	
	public AktivitetGUI()
	{
		
		//JPanel Labels
		JPanel center = new JPanel(new GridLayout(10,1));
		
		//Navne ud for textfield
		String[] labelTekster = {"Fornavn:", "Efternavn:", "Adresse:", "Telefon:"};
		
		//adder navn og tekstfield til vinduet
		LabelTextfield fornavnsBox = new LabelTextfield(labelTekster[0]);
		String fornavn = fornavnsBox.getInputText();
		center.add(fornavnsBox);
		
		LabelTextfield efternavnsBox = new LabelTextfield(labelTekster[0]);
		String efternavn = efternavnsBox.getInputText();
		center.add(efternavnsBox);
		
		LabelTextfield adresseBox = new LabelTextfield(labelTekster[0]);
		String adresse = adresseBox .getInputText();
		center.add(adresseBox );
		
		LabelTextfield telefonBox = new LabelTextfield(labelTekster[0]);
		String telefon = telefonBox.getInputText();
		center.add(telefonBox);
		
		
		Panel_Midt.add(center);
		center.setBackground(Color.WHITE);
		 btn_aktivitet.setBackground(Color.WHITE);
		 btn_gem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}//constructor slutter
	
	
}//public class medlem_GUI slutter


