package GUI;
import javax.swing.*; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Domain.ClosedColumnTableModel;
import Domain.Control;
import Domain.Medlem;

import java.util.*;
import java.util.regex.PatternSyntaxException;

public class MedlemTabel implements ActionListener,KeyListener {


	private ArrayList<Medlem> opdateMedlemmer = new ArrayList<Medlem>();
	private ArrayList<String> data = new ArrayList<String>();
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private int selectedRow;
	private MedlemGUI medlemGUI;
	
	private JTextField searchField = new JTextField();
	private JButton btn_opdater = new JButton("Opdater Medlemmer");
	private JButton btn_slet = new JButton("Slet Medlem");

	private ClosedColumnTableModel model = new ClosedColumnTableModel();
	private TableRowSorter<TableModel> rowSorter;


	/**
	 * Denne klasse styrer et JTable, som er redigerbart, med funktioner til at ændre diverse værdier direkte i databasen,<br>
	 *  for hvert medlem. Og slette medlemmer direkte fra systemet og databasen.
	 *  
	 *  <p>Det er mulighed for at søge i JTablet, og for at sortere i det.</p>
	 * @param medlemGUI
	 */
	public MedlemTabel(MedlemGUI medlemGUI){
		frame = new JFrame ();
		this.medlemGUI = medlemGUI;
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel();

		//Opretter JTable
		table = new JTable();
		table.setModel(model);
		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);
		centerPanel.add(table);


		frame.setLayout(new BorderLayout());
		frame.setSize(800, 300);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Vis medlemmer");    


		//North Panel
		northPanel.setLayout(new GridLayout(1,3));     
		frame.add(northPanel, BorderLayout.NORTH);

		//South Panel
		southPanel.setLayout(new GridLayout(0,4));
		frame.add(southPanel, BorderLayout.SOUTH); 

		//Center Panel
		centerPanel.setLayout(new GridLayout(1,2));
		frame.add(centerPanel, BorderLayout.CENTER);

		// add scrollpane to table
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane);

		searchField.addKeyListener(this);
		northPanel.add(searchField);	      

		btn_opdater.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_opdater.addActionListener(this);
		southPanel.add(btn_opdater);

		btn_slet.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_slet.addActionListener(this);
		southPanel.add(btn_slet);

		updateJTable();
		frame.setVisible(true);
	}

	/**
	 * Metode for at opdatere JTable, med en ArrayListe. 
	 * Sætter columns og rows op for JTablet.
	 */
	public void updateJTable() {
		ArrayList<Medlem> medlemmer = new Control().hentMedlemmer();
		// add the column names
		model.setColumnIdentifiers(new String[] { "id", "Fornavn", "Efternavn", "Adresse", "Fødselsdato", "Telefon", "Email", "Navn på dør", "Billeder" });

		// Foreach loop to loop through the ArrayList. One row (person) at a
		// time
		for (Medlem medlem : medlemmer) {
			model.addRow(new Object[] {
					medlem.getId(),
					medlem.getFornavn(),
					medlem.getEfternavn(),
					medlem.getAdresse(),
					medlem.getFødselsdato(),
					medlem.getTelefon(),
					medlem.getEmail(),
					medlem.getNavnPåDør(),
					medlem.getBilleder()});
		}
		medlemmer.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_opdater){
			model.fireTableDataChanged();
			int row;
			int column;
			for(row = 0; row < model.getRowCount(); row++){
				for(column = 0; column < model.getColumnCount(); column++){
					data.add(model.getValueAt(row, column).toString());					
				}
				opdateMedlemmer.add(new Medlem(Integer.parseInt(data.get(0)), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), Integer.parseInt(data.get(8))));
				data.clear();
			}
			new Control().opdaterMedlemmer(opdateMedlemmer);
			medlemGUI.updateJTable();
		}

		if (e.getSource() == btn_slet){
			selectedRow = table.getSelectedRow();
			int reply = JOptionPane.showConfirmDialog(frame,"Er du sikker på, at du vil slette "+ model.getValueAt(selectedRow, 1) +"?","Bekræft sletning", JOptionPane.YES_NO_OPTION);
			if(reply==0){
			int identifier = 0;
			try{
			identifier = (int) model.getValueAt(selectedRow,0);
			model.removeRow(selectedRow);
			new Control().sletMedlem(identifier);
			}catch(ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(frame,"Du har ikke valgt et medlem.");
			}
			medlemGUI.updateJTable();
		}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

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
					 * der ikke tages højde for store/små bostaver når der søges.
					 */
					try{
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text));
						}catch(PatternSyntaxException e1){
						}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
}
