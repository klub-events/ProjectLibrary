package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import Domain.Control;
import Domain.Medlem;

import java.util.*;

public class MedlemTabel implements ActionListener {


	private ArrayList<Medlem> opdateMedlemmer = new ArrayList<Medlem>();
	private ArrayList<String> data = new ArrayList<String>();
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private int rowSet;
	private int selectedRow;

	private JTextField search = new JTextField();
	private JButton btn_opdater = new JButton("Opdater Medlemmer");
	private JButton btn_slet = new JButton("Slet Medlem");

	private DefaultTableModel model = new DefaultTableModel();


	public MedlemTabel(){
		frame = new JFrame ();

		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel();

		//Table of content
		table = new JTable();
		table.setModel(model);
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


		northPanel.add(search);	      

		btn_opdater.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_opdater.addActionListener(this);
		southPanel.add(btn_opdater);

		btn_slet.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_slet.addActionListener(this);
		southPanel.add(btn_slet);

		updateJTable();
		frame.setVisible(true);
	}

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

		//til patrick
		//for (Medlem medlem : medlemmer){
		//arrayList.add(medlem.getFornavn();
		//}

		//JCombobox aktivitetsMedlemmer(arrayList);
		// add the DefaultTableModel to the JTable
		medlemmer.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_opdater){
			model.fireTableDataChanged();
			int row;
			int column;
			System.out.println(model.getRowCount() + ", " + model.getColumnCount());
			for(row = 0; row < model.getRowCount(); row++){
				for(column = 0; column < model.getColumnCount(); column++){
					System.out.println(row +", " +column);
					data.add(model.getValueAt(row, column).toString());					
				}
				opdateMedlemmer.add(new Medlem(Integer.parseInt(data.get(0)), data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)), data.get(6), data.get(7), Integer.parseInt(data.get(8))));
				System.out.println(data);
				data.clear();
			}
			new Control().updateDB(opdateMedlemmer);
		}

		if (e.getSource() == btn_slet){
			selectedRow = table.getSelectedRow();
			int identifier = (int) model.getValueAt(selectedRow,0);
			model.removeRow(selectedRow);
			new Control().sletMedlem(identifier);

		}
	} 
}
