package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Domain.Barbog;
import Domain.Control;

public class BarBogGUI extends MainGUI implements ActionListener {
	private JTable table;

	private JButton btnTraek = new JButton("Træk");
	private JButton btnIndsaet = new JButton("Indsæt");
	private JButton btn_search;

	private JTextField searchField = new JTextField();
	private JTextField beloebField = new JTextField();
	private JTextField indsaetField = new JTextField();


	private JTextField idField = new JTextField();
	private JTextField navnField = new JTextField();
	private JTextField saldoField = new JTextField();

	private JLabel idLabel = new JLabel("ID");
	private JLabel navnLabel = new JLabel("Navn");
	private JLabel saldoLabel = new JLabel("Saldo");
	private JLabel beloebLabel = new JLabel("Beløb til behandling");

	private MyTableModel model = new MyTableModel();
	private TableRowSorter<TableModel> rowSorter;
	private int selectedRow;
	private boolean isListenerActive = true;

	public BarBogGUI() {
		JPanel center3 = new JPanel();
		center3.setLayout(null);

		// Buttons
		btnIndsaet.setBounds(50, 100, 100, 60);
		btnIndsaet.addActionListener(this);

		btnTraek.setBounds(50, 170, 100, 60);
		btnTraek.addActionListener(this);

		btn_search = new JButton("SØG");btn_search.setBounds									(580, 20, 60, 30);
		btn_search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_search.addActionListener(this);

		// Edit TextFields
		beloebField.setBounds(170, 140, 120, 60);
		searchField.setBounds(640, 20, 190, 30);

		// Non-edit TextFields
		idField.setBounds(50, 50, 25, 20);
		idField.setEditable(false);
		idField.setText("N/A");

		navnField.setBounds(110, 50, 50, 20);
		navnField.setEditable(false);
		navnField.setText("N/A");

		saldoField.setBounds(170, 50, 50, 20);
		saldoField.setEditable(false);
		saldoField.setText("N/A");

		// Labels
		idLabel.setBounds(50, 30, 20, 20);
		navnLabel.setBounds(110, 30, 50, 20);
		saldoLabel.setBounds(170, 30, 50, 20);
		beloebLabel.setBounds(170, 120, 120, 20);

		// Indsætter content til framen, til framen.
		center3.add(saldoLabel);
		center3.add(idLabel);
		center3.add(navnLabel);
		center3.add(saldoField);
		center3.add(navnField);
		center3.add(idField);
		center3.add(btnTraek);
		center3.add(btnIndsaet);
		center3.add(indsaetField);
		center3.add(beloebField);
		center3.add(beloebLabel);
		center3.add(searchField);
		center3.add(btn_search);

		// Jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(580, 50, 250, 500); // x, y, width, height
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		table.setModel(model);
		center3.add(scrollPane);
		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);

		System.out.println();

		// tilføj content til gui
		Panel_Content.add(center3);
		center3.setBackground(Color.WHITE);
		btn_saldo.setBackground(Color.GRAY);

		/*
		 * 
		 * En List Selection Listener. Checker på mouseinput, om selectedRow er
		 * selected.. Hvis en row bliver selected udfører den var.setText(var)
		 * tingene..
		 */
		table.getSelectionModel().addListSelectionListener(

				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						if (isListenerActive) {
							try{
								int selectedRow;
								selectedRow = table.getSelectedRow();
								String id = String.valueOf((int) model.getValueAt(
										selectedRow, 0));
								String navn = (String) model.getValueAt(
										selectedRow, 1);
								String saldo = String.valueOf((int) model
										.getValueAt(selectedRow, 2));
								String note = (String) model.getValueAt(
										selectedRow, 3);
								
								idField.setText(id);
								navnField.setText(navn);
								saldoField.setText(saldo);
							}catch(ArrayIndexOutOfBoundsException e1){

							}
						}
					}

				});
		updateJTable();
	}

	public boolean validateInput() {
		String noget = beloebField.getText();
		System.out.println(noget);
		boolean valid = noget.matches("[0-9]+");
		return valid;
	}

	public void updateJTable() {
		// Henter Barbogs værdier fra db
		ArrayList<Barbog> barbogs = new Control().hentBarbog();

		model.setColumnIdentifiers(new String[] { "ID", "Navn", "Saldo" });
		//Da list Listener lytter på hvilket row der er selected.
		for (int i = 0; i < model.getColumnCount(); i++){
			rowSorter.setSortable(i, false);}
		for (Barbog barbog : barbogs) {
			model.addRow(new Object[] { barbog.getId(), barbog.getNavn(),
					barbog.getSaldo(), });
		}
		barbogs.clear();
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn_search){
			String text = searchField.getText().toLowerCase();
			if (text.length() == 0) {
				rowSorter.setRowFilter(null);
			} else {
				rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));;
			}
		}
		if (e.getSource() == btn_aktivitet) {
			new AktivitetGUI();

			frame.dispose();
		}

		if (e.getSource() == btn_medlem) {
			new MedlemGUI();

			frame.dispose();
		}

		if (e.getSource() == btn_tilmeld) {
			new TilmeldAktivitetGUI();

			frame.dispose();
		}

		if (e.getSource() == btnIndsaet) {
			int input = 0;
			int saldo = 0;
			int id = 0;
			selectedRow = table.getSelectedRow();

			try {
				input = Integer.parseInt(beloebField.getText());
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(frame, "Forket indtastet beløb.");
			}
			try {
				id = (int) (model.getValueAt(selectedRow, 0));
				saldo = Integer.parseInt(saldoField.getText());
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(frame, "Intet medlem er valgt.");
			}
			Boolean result = validateInput();
			beloebField.setText(null);

			System.out.println(result);
			if(result){
				if (table.getSelectedRow() >= 0) {
					new Control().indsaetBeloeb(saldo, input, id);
					isListenerActive = false;
					model.setRowCount(0);
					updateJTable();
					model.fireTableDataChanged();
					isListenerActive = true;
					table.addRowSelectionInterval(selectedRow, selectedRow);
				}
			}
			else{
				JOptionPane.showMessageDialog(frame, "syntaksen på beløbet er forkert");
			}
		}

		if (e.getSource() == btnTraek) {
			int id = 0;
			int input = 0;
			int saldo = 0;
			selectedRow = table.getSelectedRow();

			try {
				input = Integer.parseInt(beloebField.getText());
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(frame, "Forket indtastet beløb.");
			}
			try {
				id = (int) (model.getValueAt(selectedRow, 0));
				saldo = Integer.parseInt(saldoField.getText());
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(frame, "Intet medlem er valgt.");
			}
			Boolean result = validateInput();
			beloebField.setText(null);
			if(result){
				if (table.getSelectedRow() >= 0) {
					isListenerActive = false;
					model.setRowCount(0);
					new Control().traekBeloeb(saldo, input, id);
					updateJTable();
					model.fireTableDataChanged();
					isListenerActive = true;
					table.addRowSelectionInterval(selectedRow, selectedRow);
				}
			}
			else{
				JOptionPane.showMessageDialog(frame, "syntaksen på beløbet er forkert");
			}

		}
	}
}