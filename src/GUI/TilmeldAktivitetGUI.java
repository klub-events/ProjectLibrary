package GUI;

import java.awt.Color; 
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JComboBox medlem;
	private String[] medlemValg = {"svend"};

	@SuppressWarnings({ "rawtypes" })

	//combobox aktivitet
	private JComboBox aktivitet;
	private String[] aktivitetValg = {"fodbold"};

	JButton btn_gem = new JButton("GEM");

	private String fk_medlemNavn;
	private int fk_aktivitetID;

	private JTable table;
	private MyTableModel model = new MyTableModel();
	private TableRowSorter<TableModel> rowSorter;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TilmeldAktivitetGUI()
	{
       // MANGLER DB DATA I DROP DOWN OG BEGGE SKAL VÆRE INT OG DE SKAL JOINES OG DATA SKAL I JTABLE
		// fejl ved upload pga hardcoded shit men det kommer i db
		JPanel panel2 = new JPanel(new GridLayout(0, 1));


		//medlems dropdown
		medlem = new JComboBox(medlemValg);
		medlem.setSelectedIndex(0);
		medlem.setBackground(Color.white);
		JPanel panel1 = new JPanel(new FlowLayout());
		JLabel label1 = new JLabel("Hvilket medlem skal tilmeldes: ");
		panel1.add(label1);
		panel1.add(medlem);


		//aktivitet dropdown
		aktivitet = new JComboBox(aktivitetValg);
		aktivitet.setSelectedIndex(0);
		aktivitet.setBackground(Color.white);
		JLabel label2 = new JLabel("Hvilken aktivets skal der tilmeldes til: ");
		panel1.add(label2);
		panel1.add(aktivitet);


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
			try{
				if (aktivitet.getSelectedItem() == "fodbold") {
					fk_aktivitetID = 2;
				} else {
					fk_aktivitetID = 2;
				}
				if (medlem.getSelectedItem() == "svend") {
					fk_medlemNavn = "svend";

				} else {
					fk_medlemNavn = "svend";
				}
				Tilmeld m = new Tilmeld(fk_medlemNavn, fk_aktivitetID);
				new Control().opretTilmelding(m);
				System.out.println("her til");


			}catch(Exception e1){
				JOptionPane.showMessageDialog(frame,"Et eller flere felter er ikke blevet udfyldt. Udfyld alle felter, og prøv igen.");
			}
		}

	}
}//public class slutter
