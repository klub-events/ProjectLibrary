package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Domain.*;

public class MedlemGUI extends MainGUI implements ActionListener {
	private JButton btn_opretMedlem = new JButton("OPRET");

	private JButton btn_visMember = new JButton("VIS MEMBER");

	// Værdier for indtastede oplysnigner
	private String fornavn;
	private String efternavn;
	private String adresse;
	private int foedselsdato;
	private int telefon;
	private String email;
	private String navnDoer;
	private int billeder;

	// Text-label fields created
	private LabelTextfield forNavnBox;
	private LabelTextfield efterNavnBox;
	private LabelTextfield adresseBox;
	private LabelTextfield foedselsdatoBox;
	private LabelTextfield telefonBox;
	private LabelTextfield emailBox;
	private LabelTextfield navnDoerBox;

	private JComboBox billedeValg;
	private String[] comboValg = { "Nej", "Ja" };

	public MedlemGUI() {

		// JPanel Labels
		JPanel content2 = new JPanel(new GridLayout(11, 1));

		// Navne ud for textfield
		String[] labelTekster = { "fornavn:", "efternavn", "adresse:",
				"foedselsdato:", "telefon:", "email", "navn på doer:",
				"billeder" };

		// adder navn og tekstfield til vinduet
		forNavnBox = new LabelTextfield(labelTekster[0]);
		content2.add(forNavnBox);

		// adder navn og tekstfield til vinduet
		efterNavnBox = new LabelTextfield(labelTekster[1]);
		content2.add(efterNavnBox);

		adresseBox = new LabelTextfield(labelTekster[2]);
		content2.add(adresseBox);

		// dato api
		foedselsdatoBox = new LabelTextfield(labelTekster[3]);
		content2.add(foedselsdatoBox);

		telefonBox = new LabelTextfield(labelTekster[4]);
		content2.add(telefonBox);

		emailBox = new LabelTextfield(labelTekster[5]);
		content2.add(emailBox);

		navnDoerBox = new LabelTextfield(labelTekster[6]);
		content2.add(navnDoerBox);

		// skal have label foran som de andre :S
		billedeValg = new JComboBox(comboValg);
		billedeValg.setSelectedIndex(0);
		// billedeValg.setLayout(new GridLayout(1, 1));

		content2.add(billedeValg);

		Panel_Content.add(content2);
		content2.setBackground(Color.WHITE);

		btn_medlem.setBackground(Color.white);

		btn_opretMedlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_opretMedlem.addActionListener(this);
		content2.add(btn_opretMedlem);

		btn_visMember.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_visMember.addActionListener(this);

		content2.add(btn_visMember);

	}// constructor slutter
	
	public void clearAll(){
		forNavnBox.setText(null);
		efterNavnBox.setText(null);
		adresseBox.setText(null);
		foedselsdatoBox.setText(null);
		telefonBox.setText(null);
		emailBox.setText(null);
		navnDoerBox.setText(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_opretMedlem) 
		{
			
		// Hvis en tekstbox er tom bliver der ikke addet til databasen
			if(forNavnBox.getInputText().equals(""))
			{
				JOptionPane.showMessageDialog(frame,
						"UPS alle tekstbokse skal være udfyldt");	
			}
			else
			{
				
				fornavn = forNavnBox.getInputText();
				efternavn = efterNavnBox.getInputText();
				adresse = adresseBox.getInputText();
				foedselsdato = Integer.parseInt(foedselsdatoBox.getInputText());
				telefon = Integer.parseInt(telefonBox.getInputText());
				email = emailBox.getInputText();
				navnDoer = navnDoerBox.getInputText();
				if (billedeValg.getSelectedItem() == "Ja") {
					billeder = 1;
				} else {
					billeder = 0;
				}
				Medlem m = new Medlem(0, fornavn, efternavn, adresse, foedselsdato,
						telefon, email, navnDoer, billeder);
				System.out.println(m.toString());
				new Control().opretMedlem(m);

				JOptionPane.showMessageDialog(frame,
						"Medlemmet er nu tilføjet til databasen");
				clearAll();
			}
			
		}

		if (e.getSource() == btn_aktivitet) {
			new AktivitetGUI();

			frame.dispose();
		}

		if (e.getSource() == btn_saldo) {
			new BarBogGUI();

			frame.dispose();
		}

		if (e.getSource() == btn_tilmeld) {
			new TilmeldAktivitetGUI();

			frame.dispose();
		}

		if (e.getSource() == btn_visMember) {
			new MedlemTabel();
		}

	}// actionPerformed slutter
}// public class medlem_GUI slutter
