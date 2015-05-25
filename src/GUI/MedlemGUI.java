package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Domain.*;

public class MedlemGUI extends MainGUI {
	{
		btn_medlem.setBackground(Color.white);
	}
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

	@SuppressWarnings("rawtypes")
	private JComboBox billedeValg;
	private String[] comboValg = { "Nej", "Ja" };

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MedlemGUI() {
		// Tilføjer et panel som alle
		JPanel content2 = new JPanel(new GridLayout(0, 1));

		// Tilføjer labelTextFields til content2 panel
		forNavnBox = new LabelTextfield("fornavn:");
		efterNavnBox = new LabelTextfield("efternavn");
		adresseBox = new LabelTextfield("adresse:");
		foedselsdatoBox = new LabelTextfield("foedselsdato:");
		telefonBox = new LabelTextfield("telefon:");
		emailBox = new LabelTextfield("email");
		navnDoerBox = new LabelTextfield("navn på doer:");

		billedeValg = new JComboBox(comboValg);
		billedeValg.setSelectedIndex(0);
		billedeValg.setBackground(Color.white);
		JPanel panel1 = new JPanel(new FlowLayout());
		JLabel label1 = new JLabel("Tillade Deling af billeder?: ");
		panel1.add(label1);
		panel1.add(billedeValg);

		btn_opretMedlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_opretMedlem.addActionListener(this);
		btn_visMember.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_visMember.addActionListener(this);

		// Tilføjer content til content2 panelet
		content2.add(forNavnBox);
		content2.add(efterNavnBox);
		content2.add(adresseBox);
		content2.add(foedselsdatoBox);
		content2.add(telefonBox);
		content2.add(emailBox);
		content2.add(navnDoerBox);
		content2.add(panel1);
		content2.add(btn_opretMedlem);
		content2.add(btn_visMember);
		content2.setBackground(Color.WHITE);

		// Tilføjer al contentet fra content2 panelet, til main GUI center
		// panelet for denne klasse
		Panel_Content.add(content2);
	}

	// For at rydde tekstfields når medlem er oprettet
	// Gør det letter for bruger, hurtigt at oprette nye medlemmer
	public void clearAll() {
		forNavnBox.setText(null);
		efterNavnBox.setText(null);
		adresseBox.setText(null);
		foedselsdatoBox.setText(null);
		telefonBox.setText(null);
		emailBox.setText(null);
		navnDoerBox.setText(null);
	}

	public boolean validateInput() {
		if 		(  !forNavnBox.getInputText().equals(null)
				&& !efterNavnBox.getInputText().equals(null)
				&& !adresseBox.getInputText().equals(null)
				&& !foedselsdatoBox.getInputText().equals(null)
				&& !telefonBox.getInputText().equals(null)
				&& !emailBox.getInputText().equals(null)
				&& !navnDoerBox.getInputText().equals(null)) {
			return true;
		} else {
			return false;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_opretMedlem) {

			// Anskaffer input tekst fra hver af TekstFieldsne.
			// Anvender selvkreeret getInputText() for at få input
			// er at finde i LabelTextField klassen.
			fornavn = forNavnBox.getInputText();
			efternavn = efterNavnBox.getInputText();
			adresse = adresseBox.getInputText();
			try {
				foedselsdato = Integer.parseInt(foedselsdatoBox.getInputText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(frame,"Der skal indtastes en fødselsdato af formaten 121295");
			}
			try {
			telefon = Integer.parseInt(telefonBox.getInputText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(frame,"Der skal indtastes et telefon nummer på 8 cifre af formaten 12345678");
			}
			email = emailBox.getInputText();
			navnDoer = navnDoerBox.getInputText();

			if (billedeValg.getSelectedItem() == "Ja") {
				billeder = 1;
			} else {
				billeder = 0;
			}
			
			if(!validateInput()){
				Medlem m = new Medlem(0, fornavn, efternavn, adresse, foedselsdato,
						telefon, email, navnDoer, billeder);
				new Control().opretMedlem(m);
				JOptionPane.showMessageDialog(frame, "Medlemmet: " + m.getFornavn()
						+ " er nu tilføjet til databasen med ID: " + m.getId());
				clearAll();
			}
			else{
				JOptionPane.showMessageDialog(frame,"Et eller flere felter er ikke blevet udfyldt. Udfyld alle felter, og prøv igen.");
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

	}
}
