package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import Domain.Barbog;
import Domain.Control;
import Domain.Medlem;

import java.util.*;

public class MedlemTabel implements ActionListener {
	
	
	private ArrayList<Medlem> opdateMedlemmer = new ArrayList<Medlem>();
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private ArrayList<String> data = new ArrayList<String>();
	private JPanel eastPanel;
	private int rowSet;
	private JButton btn_opdater = new JButton("Opdater");
	private Control con;

	
	private DefaultTableModel model = new DefaultTableModel();
	
	public MedlemTabel(){
		 frame = new JFrame ();
	      
	      northPanel = new JPanel();
	      southPanel = new JPanel();
	      centerPanel = new JPanel();
	      eastPanel = new JPanel();
	      
	      //Table of content
	      table = new JTable();
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
	      	      
	      btn_opdater.setCursor(new Cursor(Cursor.HAND_CURSOR));
	      btn_opdater.addActionListener(this);
	      southPanel.add(btn_opdater);
			  
	      // call the method updateJTable()
	      updateJTable();
	      
	      frame.setVisible(true);
	   }
	
	public void updateJTable() {
		 ArrayList<Medlem> medlemmer = new Control().hentMedlemmer();
	   	// add the column names
	      model.setColumnIdentifiers(new String[] { "id", "Fornavn", "Efternavn", "Adresse", "Fødselsdato", "Telefon", "Email", "Navn på dør", "Billeder" });
	   
	   	// set how many rows will be in the table
	      model.setRowCount(medlemmer.size());
	   
	   	// create a counter for counting what row we are in
	      rowSet = 0;
	   
	   	// Foreach loop to loop through the ArrayList. One row (person) at a
	   	// time
	      for (Medlem medlem : medlemmer) {
	         model.setValueAt(medlem.getId(), rowSet, 0);
	         model.setValueAt(medlem.getFornavn(), rowSet, 1);
	         model.setValueAt(medlem.getEfternavn(), rowSet, 2);
	         model.setValueAt(medlem.getAdresse(), rowSet, 3);
	         model.setValueAt(medlem.getFødselsdato(), rowSet, 4);
	         model.setValueAt(medlem.getTelefon(), rowSet, 5);
	         model.setValueAt(medlem.getEmail(), rowSet, 6);
	         model.setValueAt(medlem.getNavnPåDør(), rowSet, 7);
	         model.setValueAt(medlem.getBilleder(), rowSet, 8);
	         rowSet++;
	      }
	   	// add the DefaultTableModel to the JTable
	      table.setModel(model);
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
				opdateMedlemmer.add(new Medlem(Integer.parseInt(data.get(0)), data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)), data.get(6), data.get(7), Integer.parseInt(data.get(8))));
				System.out.println(data);
				data.clear();
			}
			 new Control().updateDB(opdateMedlemmer);
		}
	}
 
}
