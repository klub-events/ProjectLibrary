package Datalink;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.io.*;
public class Medlem_tabel {
	public ArrayList<Medlemmer> medlemmer;
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	
	private DefaultTableModel model = new DefaultTableModel();
	
	public Medlem_tabel(ArrayList<Medlemmer> medlemmer){
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
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	      for (Medlemmer medlem : medlemmer) {
	         model.setValueAt(medlem.id, rowSet, 0);
	         model.setValueAt(medlem.fornavn, rowSet, 1);
	         model.setValueAt(medlem.efternavn, rowSet, 2);
	         model.setValueAt(medlem.adresse, rowSet, 3);
	         model.setValueAt(medlem.fødselsdato, rowSet, 4);
	         model.setValueAt(medlem.telefon, rowSet, 5);
	         model.setValueAt(medlem.email, rowSet, 6);
	         model.setValueAt(medlem.navnPåDør, rowSet, 7);
	         model.setValueAt(medlem.billeder, rowSet, 8);
	         rowSet++;
	      }
	   	// add the DefaultTableModel to the JTable
	      table.setModel(model);
	   }
	}
