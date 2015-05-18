package GUI;
import javax.swing.*;

import java.awt.*;

import javax.swing.table.DefaultTableModel;

import Datalink.DBHentBarbog;
import Domain.Barbog;

import java.util.*;

public final class BarbogTabel {
	private ArrayList<Barbog> barbogs;
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;

	
	private DefaultTableModel model = new DefaultTableModel();
	
	public BarbogTabel(ArrayList<Barbog> barbogs){
	this.barbogs = barbogs;
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
	      frame.setTitle("Vis barbog");    
	      
	      
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
	      model.setColumnIdentifiers(new String[] { "ID", "Pris", "Vare", "Tilgængelig", "VigtigNote", "Saldo" });
	   
	   	// set how many rows will be in the table
	      model.setRowCount(barbogs.size());
	   
	   	// create a counter for counting what row we are in
	      int rowSet = 0;
	   
	   	// Foreach loop to loop through the ArrayList. One row (bar-oversigt) at a
	   	// time
	      for (Barbog barbog : barbogs) {
	         model.setValueAt(barbog.getId(), rowSet, 0);
	         model.setValueAt(barbog.getPris(), rowSet, 1);
	         model.setValueAt(barbog.getVare(), rowSet, 2);
	         model.setValueAt(barbog.getTilgængelig(), rowSet, 3);
	         model.setValueAt(barbog.getVigtigNote(), rowSet, 4);
	         model.setValueAt(barbog.getSaldo(), rowSet, 5);

	         rowSet++;
	      }
	   	// add the DefaultTableModel to the JTable
	      table.setModel(model);
	      barbogs.clear();
	   }
	}
