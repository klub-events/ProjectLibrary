package GUI;
import javax.swing.*;

import java.awt.*;

import javax.swing.table.DefaultTableModel;

import Datalink.DBConnector;
import Domain.Medlem;

import java.util.*;

public final class MedlemTabel {
	private ArrayList<Medlem> medlemmer;
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;

	
	private DefaultTableModel model = new DefaultTableModel();
	
	public MedlemTabel(ArrayList<Medlem> medlemmer){
	this.medlemmer = medlemmer;
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
	      southPanel.setLayout(new GridLayout(1,3));
	      frame.add(southPanel, BorderLayout.SOUTH); 
	      
	      //Center Panel
	      centerPanel.setLayout(new GridLayout(1,1));
	      frame.add(centerPanel, BorderLayout.CENTER);
	            	           
	      
	      // add scrollpane to table
	      JScrollPane scrollPane = new JScrollPane(table);
	      frame.add(scrollPane);
	      
	      // call the method updateJTable()
	      updateJTable();
	         
	      frame.setVisible(true);
	   }
	
	public void updateJTable() {
	   	// add the column names
	      model.setColumnIdentifiers(new String[] { "id", "Fornavn", "Efternavn", "Adresse", "Fødselsdato", "Telefon", "Email", "Navn på dør", "Billeder" });
	   
	   	// set how many rows will be in the table
	      model.setRowCount(medlemmer.size());
	   
	   	// create a counter for counting what row we are in
	      int rowSet = 0;
	   
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
	}
