package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Domain.*;

public class MedlemGUI extends MainGUI implements KeyListener {
	{
		btn_medlem.setBackground(Color.white);
	}
	private JButton btn_opretMedlem;
	private JButton btn_visMember;
	private JButton btn_search;
	//DETTE ER EN TEST KNAP ----------------------------------------
	//private JButton test;
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

	private ClosedCellTableModel model = new ClosedCellTableModel();
	private JTable table;
	private TableRowSorter<TableModel> rowSorter;

	int fieldWidth = 200;
	int  fieldHeight = 30;
	int fieldBorder = 130;
	int labelBorder = 50;

	@SuppressWarnings("rawtypes")
	private JComboBox billedeValg;
	private String[] comboValg = { "Nej", "Ja" };

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MedlemGUI() {
		// Tilføjer et panel som alle
		JPanel content = new JPanel(null);
        
		//knap active
		btn_medlem.setBackground(Color.GRAY);
		fornavnField = new JTextField(); fornavnField.setBounds							(fieldBorder, 50,  fieldWidth, fieldHeight);
		efternavnField = new JTextField();efternavnField.setBounds						(fieldBorder, 110, fieldWidth, fieldHeight);
		adresseField = new JTextField();adresseField.setBounds							(fieldBorder, 170, fieldWidth, fieldHeight);
		foedselsdatoField = new JTextField();foedselsdatoField.setBounds				(fieldBorder, 230, fieldWidth, fieldHeight);
		telefonField = new JTextField();telefonField.setBounds							(fieldBorder, 290, fieldWidth, fieldHeight);
		emailField = new JTextField();emailField.setBounds								(fieldBorder, 350, fieldWidth, fieldHeight);
		navndoerField = new JTextField();navndoerField.setBounds						(fieldBorder, 410, fieldWidth, fieldHeight);
		searchField = new JTextField();searchField.setBounds							(640, 20, 190, 30);
		searchField.addKeyListener(this);
		
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
		 * DETTE ER EN TEST KNAP
		 *  
		 * 
		 *
		 test = new JButton("TEST");
		 test.setBounds(550,530 , 20,20);
		 content.add(test);
		 test.addActionListener(this);
		 *
		 * 
		 * 
		 * DETTE ER EN TEST KNAP
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
	/**
	 * Sætter alle textfields indeholdt af funktionen lig null, således de er klar til nyt input fra brugeren.
	 */
	public void clearAll() {
		fornavnField.setText(null);
		efternavnField.setText(null);
		adresseField.setText(null);
		foedselsdatoField.setText(null);
		telefonField.setText(null);
		emailField.setText(null);
		navndoerField.setText(null);
	}


	/**
	 * Metode for at validerer at hver textfield indholder data til når der skal oprettes et nyt medlem.<br>
	 * ser efter om fields forbeholdt talinput, indeholder tal eller tekst med en regex sætning.
	 * @return true eller false alt efter om valideringen går i gennem eller ej
	 */
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

	/**
	 * Metode for at opdatere JTable, med en ArrayListe. 
	 * Sætter columns og rows op for JTablet.
	 */
	public void updateJTable(){
		model.setRowCount(0);
		ArrayList<Medlem> medlemmer = new Control().hentMedlemmer();

		model.setColumnIdentifiers(new String[] { "ID", "Fornavn", "Efternavn" });
		for (Medlem medlem : medlemmer) {
			model.addRow(new Object[] { medlem.getId(),medlem.getFornavn(),medlem.getEfternavn()});
		}
		medlemmer.clear();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
	/*
	 * Dette er funktionen for test knappen, brugt løbende for at teste medlems oprettelse, redigering
	 * samspil med andre klasser, og sletning fra systemet.
	 * Hurtig måde at sætte et nyt medlem op på. Ikke sikkert at bruge som sådan.
	 * 
		if(e.getSource() == test){
			Medlem medlem = new Medlem(0, "test", "test", "test", "123",
					"123", "test", "test", 1);
			new Control().opretMedlem(medlem);
			Barbog barbog = new Barbog(medlem.getId(),"null","null",0);
			new Control().opretBarbog(barbog);
		}
	*/
		
		if(e.getSource() == btn_search){
			//Sørger for at alle input bliver sat til lower case. muligvis ligegyldigt.
			String text = searchField.getText().toLowerCase();
			if (text.length() == 0) {
				rowSorter.setRowFilter(null);
			} else {
				//regexFilter (?i) fundet på internette d.28/5 på siden:
				//https://community.oracle.com/thread/1354225
				//regexFilter - sætning som sørger for at der ikke differencieres imellem store og små bogstaver
				rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text));
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
				//tester om fødselsdato fielded har modtaget et input længere end 6 karakterer. Det samme for telefonField med 12 karakterer.
				if(foedselsdatoField.getText().length()>6){JOptionPane.showMessageDialog(frame, "Din fødselsdato er for lang.");}
				else if(telefonField.getText().length()>12){JOptionPane.showMessageDialog(frame, "Dit telefon nummer er for langt.");}
				else{
				//Opretter et medlem og en barbog herti, og sender disse til databasen.
				Medlem medlem = new Medlem(0, fornavn, efternavn, adresse, foedselsdato,telefon, email, navnDoer, billeder);
				new Control().opretMedlem(medlem);
				Barbog barbog = new Barbog(medlem.getId(),"null","null",0);
				new Control().opretBarbog(barbog);
				JOptionPane.showMessageDialog(frame, "Medlemmet: " + medlem.getFornavn() + " er nu tilføjet til databasen med ID: " + medlem.getId());
				clearAll();
				//Tømmer JTablet så det er klart til at modtage nyt input, og blive opdateret med en ny ArrayListe, med opdaterede input.
				model.setRowCount(0);
				updateJTable();
				}
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
			new SaldoGUI();

			frame.dispose();
		}

		if (e.getSource() == btn_tilmeld) {
			new TilmeldAktivitetGUI();

			frame.dispose();
		}

		if (e.getSource() == btn_visMember) {
			new MedlemTabel(this);
		}
		if(e.getSource() == btn_barbog){
			new BarBogGUI();
			frame.dispose();
		}
	}

	//metoder bruges ikke, da jeg ikke behøver listene på dette
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//key listener på når man giver slip på en knap. I vores tilfælde Enter knappen.
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==searchField){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				String text = searchField.getText().toLowerCase();
				if (text.length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					/*
					 * kodestykket herunder er fundet fra siden
					 * https://community.oracle.com/thread/1354225
					 * fra bruger 843806 - regexFilter sørger for at 
					 * der ikke tages højde for store/små bostaver når der søges. Sorterer JTable/rowSorter efter kun at vise
					 * felter, med givet input.
					 */
					try{
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text));
						}catch(PatternSyntaxException e1){
						}
				}
			}
		}
	}
}

