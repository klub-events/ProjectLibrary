package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Datalink.DBHentMedlemmer;
import Domain.Medlem;

import java.util.*;

public class MedlemTabel extends AbstractTableModel implements ActionListener {
	private ArrayList<Medlem> medlemmer;
	private JFrame frame;
	private JTable table;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	
	private JButton btn_opdater;

	
	private DefaultTableModel model = new DefaultTableModel();
	
	public MedlemTabel(ArrayList	<Medlem> medlemmer){
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
	            	           
	      btn_opdater.setCursor(new Cursor(Cursor.HAND_CURSOR));
		  btn_opdater.addActionListener(this);
		  southPanel.add(btn_opdater);
	      
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_opdater){
			
		}
		
	}

	@Override
	public String getColumnName(int column){
		String name = null;
		switch (column){
		case 0:
			name = "id";
			break;
		case 1:
			name = "Fornavn";
			break;
		case 2:
			name = "Efternavn";
			break;
		case 3:
			name = "Adresse";
			break;
		case 4:
			name = "Fødselsdato";
			break;
		case 5: 
			name = "Telefon";
			break;
		case 6:
			name = "Email";
			break;
		case 7:
			name = "NavnPåDør";
			break;
		case 8:
			name = "Billeder";
			break;
		}
		return name;
	}
	
	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return medlemmer.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Medlem m = medlemmer.get(rowIndex);
		Object value = null;
		switch(columnIndex){
		case 0:
			value = m.getId();
			break;
		case 1:
			value = m.getFornavn();
			break;
		case 2:
			value = m.getEfternavn();
			break;
		case 3:
			value = m.getAdresse();
			break;
		case 4:
			value = m.getFødselsdato();
			break;
		case 5:
			value = m.getTelefon();
			break;
		case 6:
			value = m.getEmail();
			break;
		case 7:
			value = m.getNavnPåDør();
			break;
		case 8:
			value = m.getBilleder();
			break;
		}
		return null;
	}
	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		if(aValue instanceof String){
			Medlem m = medlemmer.get(rowIndex);
			switch (columnIndex){
			case 0:
				m.setId(Integer.parseInt(aValue.toString()));
				break;
			case 1:
				m.setFornavn(aValue.toString());
				break;
			case 2:
				m.setEfternavn(aValue.toString());
				break;
			case 3:
				m.setAdresse(aValue.toString());
				break;
			case 4:
				m.setFødselsdato(Integer.parseInt(aValue.toString()));
				break;
			case 5:
				m.setTelefon(Integer.parseInt(aValue.toString()));
				break;
			case 6:
				m.setEmail(aValue.toString());
				break;
			case 7:
				m.setNavnPåDør(aValue.toString());
				break;
			case 8:
				m.setBilleder(Integer.parseInt(aValue.toString()));
				break;
			}
		}
	}
	}
