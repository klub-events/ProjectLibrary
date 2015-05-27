package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Domain.*;

public class MedlemGUI extends MainGUI {
	{
		btn_medlem.setBackground(Color.white);
	}
	private JButton btn_opretMedlem;
	private JButton btn_visMember;
	private JButton btn_search;
	//DETTE ER EN TEST KNAP ----------------------------------------
	private JButton test;
	//DETTE ER EN TEST KNAP ----------------------------------------

	// Værdier for indtastede oplysnigner
	private String fornavn;
	private String efternavn;
	private String adresse;
	private String foedselsdato;
	private String telefon;
	private String email;
	private String navnDoer;
	private int billeder;

	private JTextField fornavnField;
	private JTextField efternavnField;
	private JTextField adresseField;
	private JTextField foedselsdatoField;
	private JTextField telefonField;
	private JTextField emailField;
	private JTextField navndoerField;
	private JTextField searchField;

	private JLabel fornavnLabel;
	private JLabel efternavnLabel;
	private JLabel adresseLabel;
	private JLabel foedselsdatoLabel;
	private JLabel telefonLabel;
	private JLabel emailLabel;
	private JLabel navndoerLabel;
	private JLabel billedeLabel;

	private MyTableModel model = new MyTableModel();
	private JTable table;
	private TableRowSorter<TableModel> rowSorter;

	int fieldWidth = 200;
	int  fieldHeight = 30;
	int fieldBorder = 130;
	int labelBorder = 50;

	private JComboBox billedeValg;
	private String[] comboValg = { "Nej", "Ja" };

	public MedlemGUI() {
		// Tilføjer et panel som alle
		JPanel content = new JPanel(null);

		fornavnField = new JTextField(); fornavnField.setBounds							(fieldBorder, 50,  fieldWidth, fieldHeight);
		efternavnField = new JTextField();efternavnField.setBounds						(fieldBorder, 110, fieldWidth, fieldHeight);
		adresseField = new JTextField();adresseField.setBounds							(fieldBorder, 170, fieldWidth, fieldHeight);
		foedselsdatoField = new JTextField();foedselsdatoField.setBounds				(fieldBorder, 230, fieldWidth, fieldHeight);
		telefonField = new JTextField();telefonField.setBounds							(fieldBorder, 290, fieldWidth, fieldHeight);
		emailField = new JTextField();emailField.setBounds								(fieldBorder, 350, fieldWidth, fieldHeight);
		navndoerField = new JTextField();navndoerField.setBounds						(fieldBorder, 410, fieldWidth, fieldHeight);
		searchField = new JTextField();searchField.setBounds							(640, 20, 190, 30);

		fornavnLabel = new JLabel("Fornavn:");fornavnLabel.setBounds					(labelBorder, 50,  fieldWidth, fieldHeight);
		efternavnLabel = new JLabel("Efternavn:");efternavnLabel.setBounds				(labelBorder, 110, fieldWidth, fieldHeight);
		adresseLabel = new JLabel("Adresse:");adresseLabel.setBounds					(labelBorder, 170, fieldWidth, fieldHeight);
		foedselsdatoLabel = new JLabel("Fødselsdato:");foedselsdatoLabel.setBounds		(labelBorder, 230, fieldWidth, fieldHeight);
		telefonLabel = new JLabel("Telefon:");telefonLabel.setBounds					(labelBorder, 290, fieldWidth, fieldHeight);
		emailLabel = new JLabel("Email:");emailLabel.setBounds							(labelBorder, 350, fieldWidth, fieldHeight);
		navndoerLabel = new JLabel("Dørnavn:");navndoerLabel.setBounds					(labelBorder, 410, fieldWidth, fieldHeight);
		billedeLabel= new JLabel("Tillade billed deling: ");billedeLabel.setBounds		(labelBorder, 460, fieldWidth, fieldHeight);

		billedeValg = new JComboBox(comboValg);billedeValg.setBounds					(fieldBorder+50, 460, fieldWidth-50, fieldHeight);
		billedeValg.setSelectedIndex(0);
		billedeValg.setBackground(Color.white);

		btn_opretMedlem = new JButton("OPRET MEDLEM");btn_opretMedlem.setBounds				(50, 530,  150, 30);
		btn_opretMedlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_opretMedlem.addActionListener(this);

		btn_visMember = new JButton("REDIGER MEDLEMMER");btn_visMember.setBounds			(230, 530,  160, 30);
		btn_visMember.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_visMember.addActionListener(this);

		btn_search = new JButton("SØG");btn_search.setBounds									(580, 20, 60, 30);
		btn_search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_search.addActionListener(this);

		/*-------------------------------------------------------------
		 * 
		 * 
		 * DETTE ER EN TEST KNAP, FJERN NÅR SYSTEM SKAL AFLEVERES
		 *  
		 * 
		 */
		 test = new JButton("TEST");
		 test.setBounds(550,530 , 20,20);
		 content.add(test);
		 test.addActionListener(this);
		/*
		 * 
		 * 
		 * DETTE ER EN TEST KNAP, FJERN NÅR SYSTEM SKAL AFLEVERES
		 *  
		 * 
		 -----------------------------------------------------------*/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(580, 50, 250, 500); // x, y, width, height
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		table.setModel(model);
		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);


		// Tilføjer content til content2 panelet
		content.add(fornavnField);content.add(fornavnLabel);
		content.add(efternavnField);content.add(efternavnLabel);
		content.add(adresseField);content.add(adresseLabel);
		content.add(foedselsdatoField);content.add(foedselsdatoLabel);
		content.add(telefonField);content.add(telefonLabel);
		content.add(emailField);content.add(emailLabel);
		content.add(navndoerField);content.add(navndoerLabel);
		content.add(billedeValg);content.add(billedeLabel);
		content.add(scrollPane);content.add(searchField);

		content.add(btn_opretMedlem);
		content.add(btn_visMember);
		content.add(btn_search);
		content.setBackground(Color.LIGHT_GRAY.brighter());

		Panel_Content.add(content);
		clearAll();
		updateJTable();
	}

	// For at rydde tekstfields når medlem er oprettet
	// Gør det letter for bruger, hurtigt at oprette nye medlemmer
	public void clearAll() {
		fornavnField.setText(null);
		efternavnField.setText(null);
		adresseField.setText(null);
		foedselsdatoField.setText(null);
		telefonField.setText(null);
		emailField.setText(null);
		navndoerField.setText(null);
	}


	public boolean validateInput() {
		if 		(  !fornavnField.getText().equals("")
				&& !efternavnField.getText().equals("")
				&& !adresseField.getText().equals("")
				&& !foedselsdatoField.getText().equals("")
				&& !telefonField.getText().equals("")
				&& !emailField.getText().equals("")
				&& !navndoerField.getText().equals("")
				&& foedselsdato.matches("[0-9]+")
				&& telefon.matches("[0-9]+")) {
			return true;
		} else {
			return false;
		}
	}

	public void updateJTable(){
		model.setRowCount(0);
		ArrayList<Medlem> medlemmer = new Control().hentMedlemmer();

		model.setColumnIdentifiers(new String[] { "ID", "Fornavn", "Efternavn" });
		for (Medlem medlem : medlemmer) {
			model.addRow(new Object[] { medlem.getId(),medlem.getFornavn(),medlem.getEfternavn()});
		}
		medlemmer.clear();
	}

	public void actionPerformed(ActionEvent e) {
		/*----------------------------
		 * 
		 * DETTE ER EN TEST FUNKTION
		 * 
		 */
		if(e.getSource() == test){
			Medlem medlem = new Medlem(0, "test", "test", "test", "123",
					"123", "test", "test", 1);
			new Control().opretMedlem(medlem);
			Barbog barbog = new Barbog(medlem.getId(),"null","null",0);
			new Control().opretBarbog(barbog,medlem);
		}
		/*
		 * 
		 * DETTE ER EN TEST FUNKTION
		 * 
		 ---------------------------*/
		
		if(e.getSource() == btn_search){
			String text = searchField.getText();
			if (text.length() == 0) {
				rowSorter.setRowFilter(null);
			} else {
				rowSorter.setRowFilter(RowFilter.regexFilter(text));
			}
		}

		if (e.getSource() == btn_opretMedlem) {

			// Anskaffer input tekst fra hver af TekstFieldsne.
			// Anvender selvkreeret getInputText() for at få input
			// er at finde i LabelTextField klassen.
			fornavn = fornavnField.getText();
			efternavn = efternavnField.getText();
			adresse = adresseField.getText();
			foedselsdato = foedselsdatoField.getText();
			telefon = telefonField.getText();
			email = emailField.getText();
			navnDoer = navndoerField.getText();

			if (billedeValg.getSelectedItem().equals("Ja")) {
				billeder = 1;
			} else {
				billeder = 0;
			}

			if(validateInput()){
				Medlem medlem = new Medlem(0, fornavn, efternavn, adresse, foedselsdato,
						telefon, email, navnDoer, billeder);
				new Control().opretMedlem(medlem);
				Barbog barbog = new Barbog(medlem.getId(),"null","null",0);
				new Control().opretBarbog(barbog,medlem);
				JOptionPane.showMessageDialog(frame, "Medlemmet: " + medlem.getFornavn()
						+ " er nu tilføjet til databasen med ID: " + medlem.getId());
				clearAll();
				model.setRowCount(0);
				updateJTable();
				model.fireTableDataChanged();
			}
			else{
				JOptionPane.showMessageDialog(frame,"Et eller flere felter er ikke blevet udfyldt korrekt. Udfyld alle felter, og prøv igen.");
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
			new MedlemTabel(this);
		}
	}


}

