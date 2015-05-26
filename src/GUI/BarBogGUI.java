package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//For dan
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Domain.Barbog;
import Domain.Control;
public class BarBogGUI extends MainGUI implements ActionListener{
	private JTable table;
	private JButton btnTraek = new JButton("Træk");
	private JButton btnIndsaet = new JButton("Indsæt");
	private JButton btnSomething = new JButton(" do something");
	private JTextField searchField = new JTextField();
	private JTextField traekField = new JTextField();
	private JTextField indsaetField = new JTextField();
	private JTextField idField = new JTextField();
	private JTextField navnField = new JTextField();
	private JTextField saldoField = new JTextField();
	private JTextField noteField = new JTextField();
	private JLabel idLabel = new JLabel("ID");
	private JLabel navnLabel = new JLabel("Navn");
	private JLabel noteLabel = new JLabel("Vigtig note");
	private JLabel saldoLabel = new JLabel("Saldo");
	

	private DefaultTableModel model = new DefaultTableModel();
	//command to get input from saldo-box
	//saldo = forNavnsaldo.getInputText();
	public BarBogGUI(){
		JPanel center3 = new JPanel();
		center3.setLayout(null);

		//Buttons
		idField.setBounds(50,50,25,20);
		idField.setEditable(false);
		idField.setText("N/A");
		center3.add(idField);

		navnField.setBounds(110,50,50,20);
		navnField.setEditable(false);
		navnField.setText("N/A");
		center3.add(navnField);
		
		saldoField.setBounds(170,50,50,20);
		saldoField.setEditable(false);
		saldoField.setText("N/A");
		center3.add(saldoField);
		
		noteField.setBounds(50,300,200,150);
		noteField.setEditable(false);
		noteField.setText("N/A");
		center3.add(noteField);
		
		idLabel.setBounds(50,30,20,20 );
		center3.add(idLabel);
		
		navnLabel.setBounds(110,30,50,20 );
		center3.add(navnLabel);
		
		saldoLabel.setBounds(170,30,50,20 );
		center3.add(saldoLabel);
		
		noteLabel.setBounds(50,270,100,20 );
		center3.add(noteLabel);
		
		

		//Jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(580, 50, 250, 500); // x, y, width, height
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		center3.add(scrollPane);

		//tilføj content til gui
		Panel_Content.add(center3);
		center3.setBackground(Color.WHITE);

table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent event){
				int selectedRow;
				selectedRow = table.getSelectedRow();
				String id = String.valueOf((int) model.getValueAt(selectedRow,0));
				String navn = (String) model.getValueAt(selectedRow, 1);
				String note = (String) model.getValueAt(selectedRow,2);
				String saldo = String.valueOf((int)model.getValueAt(selectedRow,3));
				idField.setText(id);
				navnField.setText(navn);
				saldoField.setText(saldo);
				noteField.setText(note);
			}
		});
		updateJTable();
	}
	
	
	
	public void updateJTable(){
		table.setModel(model);
		//Henter Barbogs værdier fra db
		ArrayList<Barbog> barbogs = new Control().hentBarbog();
		model.setColumnIdentifiers(new String[] { "ID", "Navn", "VigtigNote", "Saldo" });

		for (Barbog barbog : barbogs) {
			model.addRow(new Object[] { barbog.getId(),barbog.getNavn(), barbog.getVigtigNote(), barbog.getSaldo(), "Opdater", "Slet" });
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
	}	
}


