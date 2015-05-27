package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import Domain.Barbog;
import Domain.Control;

public class BarBogGUI extends MainGUI implements ActionListener{
	private JTable table;

	private JButton btnTraek = new JButton("Træk");
	private JButton btnIndsaet = new JButton("Indsæt");
	private JButton btnKoeb = new JButton("KØB");
	private JButton btnNote = new JButton(" Opdater");

	private JTextField searchField = new JTextField();
	private JTextField beloebField = new JTextField();
	private JTextField indsaetField = new JTextField();

	private JTextField idField = new JTextField();
	private JTextField navnField = new JTextField();
	private JTextField saldoField = new JTextField();
	private JTextField noteField = new JTextField();

	private JLabel idLabel = new JLabel("ID");
	private JLabel navnLabel = new JLabel("Navn");
	private JLabel noteLabel = new JLabel("Vigtig note");
	private JLabel saldoLabel = new JLabel("Saldo");
	private JLabel beloebLabel = new JLabel("Beløb til behandling");

	private MyTableModel model = new MyTableModel();
	private int selectedRow;
	private boolean isListenerActive = true;

	public BarBogGUI(){
		JPanel center3 = new JPanel();
		center3.setLayout(null);

		//Buttons
		btnIndsaet.setBounds(50, 100, 100, 60);
		btnIndsaet.addActionListener(this);
		
		btnTraek.setBounds(50, 170, 100, 60);
		btnTraek.addActionListener(this);
		
		btnKoeb.setBounds(300,300,200,150);
		btnKoeb.addActionListener(this);
		
		btnNote.setBounds(50, 460, 100, 30);
		btnNote.addActionListener(this);
		btnNote.setToolTipText("Åbner et vindue hvori du kan opdatere den vigtige note.");
		
		

		//Edit TextFields	
		beloebField.setBounds(170, 140, 120, 60);


		//Non-edit TextFields
		idField.setBounds(50,50,25,20);
		idField.setEditable(false);
		idField.setText("N/A");

		navnField.setBounds(110,50,50,20);
		navnField.setEditable(false);
		navnField.setText("N/A");

		saldoField.setBounds(170,50,50,20);
		saldoField.setEditable(false);
		saldoField.setText("N/A");

		noteField.setBounds(50,300,200,150);
		noteField.setEditable(false);
		noteField.setText("N/A");

		//Labels
		idLabel.setBounds(50,30,20,20 );
		navnLabel.setBounds(110,30,50,20 );
		saldoLabel.setBounds(170,30,50,20 );
		noteLabel.setBounds(50,270,100,20 );
		beloebLabel.setBounds(170, 120, 120, 20);

		//Indsætter content til framen, til framen.
		center3.add(noteLabel);
		center3.add(saldoLabel);
		center3.add(idLabel);
		center3.add(navnLabel);
		center3.add(noteField);
		center3.add(saldoField);
		center3.add(navnField);
		center3.add(idField);
		center3.add(btnTraek);
		center3.add(btnIndsaet);
		center3.add(btnKoeb);
		center3.add(indsaetField);
		center3.add(beloebField);
		center3.add(beloebLabel);
		center3.add(btnNote);
		center3.add(btnKoeb);
		//Jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(580, 50, 250, 500); // x, y, width, height
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		table.setModel(model);
		center3.add(scrollPane);
		TableColumn column = null;

		//tilføj content til gui
		Panel_Content.add(center3);
		center3.setBackground(Color.WHITE);

		/*
		 * 
		 * En List Selection Listener. Checker på mouseinput, om selectedRow er selected..
		 * Hvis en row bliver selected udfører den var.setText(var) tingene..
		 */
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event){
				if(isListenerActive){
					int selectedRow;
					selectedRow = table.getSelectedRow();
					String id = String.valueOf((int) model.getValueAt(selectedRow,0));
					String navn = (String) model.getValueAt(selectedRow, 1);
					String saldo = String.valueOf((int)model.getValueAt(selectedRow,2));
					String note = (String) model.getValueAt(selectedRow,3);
					idField.setText(id);
					navnField.setText(navn);
					saldoField.setText(saldo);
					noteField.setText(note);
				}
			}
		});
		updateJTable();
	}

	public void updateJTable(){
		//Henter Barbogs værdier fra db
		ArrayList<Barbog> barbogs = new Control().hentBarbog();

		model.setColumnIdentifiers(new String[] { "ID", "Navn", "Saldo","VigtigNote" });
		for (Barbog barbog : barbogs) {
			model.addRow(new Object[] { barbog.getId(),barbog.getNavn(), barbog.getSaldo(),barbog.getVigtigNote()});
		}
		barbogs.clear();
	}

	public void actionPerformed(ActionEvent e){
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
		
		if(e.getSource() == btnNote){
			
		}
		
		if(e.getSource() == btnKoeb){
			
		}
		
		if(e.getSource()==btnIndsaet){
			int input=0;
			int saldo=0;
			int id = 0;
			int total;
			selectedRow = table.getSelectedRow();

			try{
				input = Integer.parseInt(beloebField.getText());
			}catch(NumberFormatException|ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(frame,"Forket indtastet beløb.");
			}
			try{
				id = (int)( model.getValueAt(selectedRow,0));
				saldo = Integer.parseInt(saldoField.getText());
			}catch(NumberFormatException|ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(frame,"Intet medlem er valgt.");
			}

			total = input+saldo;
			beloebField.setText(null);
			if (table.getSelectedRow() >= 0) {
				new Control().indsaetBeloeb(total, id);
				isListenerActive = false;
				model.setRowCount(0);
				updateJTable();
				model.fireTableDataChanged();
				isListenerActive = true;
				table.addRowSelectionInterval(selectedRow,selectedRow);
			}
		}

		if(e.getSource()==btnTraek){
			int id = 0;
			int input=0;
			int saldo=0;
			int total;			
			selectedRow = table.getSelectedRow();

			try{
				input = Integer.parseInt(beloebField.getText());
			}catch(NumberFormatException|ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(frame,"Forket indtastet beløb.");
			}
			try{
				id = (int)( model.getValueAt(selectedRow,0));
				saldo = Integer.parseInt(saldoField.getText());
			}catch(NumberFormatException|ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(frame,"Intet medlem er valgt.");
			}
			total = saldo-input;
			beloebField.setText(null);		

			if (table.getSelectedRow() >= 0) {
				isListenerActive = false;
				model.setRowCount(0);
				new Control().traekBeloeb(total, id);
				updateJTable();
				model.fireTableDataChanged();
				isListenerActive = true;
				table.addRowSelectionInterval(selectedRow,selectedRow);
			}

		}
	}
}	


