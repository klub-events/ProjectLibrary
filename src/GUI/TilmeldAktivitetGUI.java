package GUI;

import java.awt.Color; 
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Domain.*;

public class TilmeldAktivitetGUI extends MainGUI implements ActionListener
{
	//combobox medlem
	@SuppressWarnings("rawtypes")
	private JComboBox medlemBox;
	private String[] medlemValg = {"svend"};

	@SuppressWarnings({ "rawtypes" })

	//combobox aktivitet
	private JComboBox aktivitetBox;
	private String[] aktivitetValg = {"fodbold"};

	JButton btn_gem = new JButton("GEM");
	private JTable table;
	private ClosedCellTableModel model = new ClosedCellTableModel();
	private TableRowSorter<TableModel> rowSorter;
	
	private ArrayList<Medlem> medlemmer = new Control().hentMedlemmer();
	private ArrayList<Aktivitet> aktiviteter = new Control().hentAktiviteter();
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TilmeldAktivitetGUI()
	{
		JPanel panel2 = new JPanel(new GridLayout(0, 1));

		

		//medlems dropdown
		medlemBox = new JComboBox();
		for(Medlem medlem : medlemmer){
		medlemBox.addItem(medlem);
		}
		medlemBox.setSelectedIndex(0);
		medlemBox.setBackground(Color.white);
		JPanel panel1 = new JPanel(new FlowLayout());
		JLabel label1 = new JLabel("Hvilket medlem skal tilmeldes: ");
		panel1.add(label1);
		panel1.add(medlemBox);

		//aktivitet dropdown
		aktivitetBox = new JComboBox();
		for(Aktivitet aktivitet : aktiviteter){
			aktivitetBox.addItem(aktivitet);
			}
		aktivitetBox.setBackground(Color.white);
		JLabel label2 = new JLabel("Hvilken aktivets skal der tilmeldes til: ");
		panel1.add(label2);
		panel1.add(aktivitetBox);


		//gem knap
		btn_gem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_gem.addActionListener(this);
		panel1.add(btn_gem);



		// Jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 250, 500); // x, y, width, height
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		table.setModel(model);
		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.add(scrollPane);
		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);

		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);

		//adder til frame
		panel2.add(panel1);
		Panel_Content.add(panel2);
		panel2.add(panel3);		

		btn_tilmeld.setBackground(Color.GRAY);
		
		
	}//constructor slutter

	public void actionPerformed(ActionEvent e)
	{
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

		if(e.getSource() == btn_saldo ){
			new BarBogGUI();

			frame.dispose();
		}

		if(e.getSource() == btn_gem){
			Medlem m = (Medlem) medlemBox.getSelectedItem();
			Aktivitet a = (Aktivitet) aktivitetBox.getSelectedItem();
			String fk_medlemNavn = m.getFornavn();
			int fk_aktivitetID = a.getId();
			try{
				
				Tilmeld tilmelding = new Tilmeld(0, fk_medlemNavn, fk_aktivitetID);
				new Control().opretTilmelding(tilmelding);
				System.out.println("her til");


			}catch(Exception e1){
				JOptionPane.showMessageDialog(frame,"Et eller flere felter er ikke blevet udfyldt. Udfyld alle felter, og prøv igen.");
			}
		}

	}
}//public class slutter
