package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import Domain.Barbog;
import Domain.Control;

import java.util.*;

public class BarbogTabel implements ActionListener {
	private ArrayList<Barbog> opdateBarbog = new ArrayList<Barbog>();
	private ArrayList<String> data = new ArrayList<String>();
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JButton btn_opdater = new JButton("Opdater");

	
	private DefaultTableModel model = new DefaultTableModel();
	
	public BarbogTabel(){
		 frame = new JFrame ();
	      
	      northPanel = new JPanel();
	      southPanel = new JPanel();
	      centerPanel = new JPanel();
	      new JPanel();
	      
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
	      
	      //implements the btn_updater on the jtable
	      btn_opdater.setCursor(new Cursor(Cursor.HAND_CURSOR));
	      btn_opdater.addActionListener(this);
	      southPanel.add(btn_opdater);
	      
	      // call the method updateJTable()
	      updateJTable();
	         
	      frame.setVisible(true);
	   }
	
	public void updateJTable() {
		//Henter Barbogs værdier fra db
		ArrayList<Barbog> barbogs = new Control().hentBarbog();
	   	// add the column names
	      model.setColumnIdentifiers(new String[] { "ID", "Navn", "VigtigNote", "Saldo" });
	   
	   	// set how many rows will be in the table
	      model.setRowCount(barbogs.size());
	   
	   	// create a counter for counting what row we are in
	      int rowSet = 0;
	   
	   	// Foreach loop to loop through the ArrayList. One row (bar-oversigt) at a
	   	// time
	      for (Barbog barbog : barbogs) {
	         model.setValueAt(barbog.getId(), rowSet, 0);
	         model.setValueAt(barbog.getNavn(), rowSet, 1);
	         model.setValueAt(barbog.getVigtigNote(), rowSet, 2);
	         model.setValueAt(barbog.getSaldo(), rowSet, 3);

	         rowSet++;
	      }
	   	// add the DefaultTableModel to the JTable
	      table.setModel(model);
	      barbogs.clear();
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
					//				Barbog-objekts values:		int id,  	String navn, 		String vigtigNote, 	int saldo
				opdateBarbog.add(new Barbog(Integer.parseInt(data.get(0)), data.get(1), data.get(2), Integer.parseInt(data.get(3))));
				System.out.println(data);
				data.clear();
			}
			 new Control().opdaterBarbog(opdateBarbog);
		}
	}
	}
