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

/**Denne klasse extender MainGUI som er den alle sider har tilfælles og 
 * implementer Actionlistener får at knapper kan have funktionalitet.
 * Indeholder JComboBox, JTable og JButtons. 
 * @author PatrickRavnsholt
 *
 */
public class TilmeldAktivitetGUI extends MainGUI implements ActionListener
{
	//combobox medlem
	@SuppressWarnings("rawtypes")
	private JComboBox medlemBox;


	@SuppressWarnings({ "rawtypes" })

	//combobox aktivitet
	private JComboBox aktivitetBox;


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


		//aktivitet dropdown
		aktivitetBox = new JComboBox();
		for(Aktivitet aktivitet : aktiviteter){
			aktivitetBox.addItem(aktivitet);
		}
		aktivitetBox.setBackground(Color.white);
		JLabel label2 = new JLabel("Hvilken aktivets skal der tilmeldes til: ");



		//gem knap
		btn_gem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_gem.addActionListener(this);



		// Jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 250, 200); // x, y, width, height
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		table.setModel(model);
		JPanel panel3 = new JPanel(new GridLayout(1,1));
		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);
		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);
		updateJTable();

		btn_tilmeld.setBackground(Color.GRAY);

		//adder til frame
		panel1.add(label1);
		panel1.add(medlemBox);
		panel1.add(label2);
		panel1.add(aktivitetBox);
		panel1.add(btn_gem);
		panel3.add(scrollPane);
		panel2.add(panel1);
		Panel_Content.add(panel2);
		panel2.add(panel3);		




	}//constructor slutter

	/**
	 * adder database udtræk til jtable
	 */
	public void updateJTable() 
	{
		ArrayList<Tilmeld> medlemmer = new Control().hentTilmeldinger();
		// add the column names
		model.setColumnIdentifiers(new String[] {"Aktivitet", "Navn"});

		//looper aktiviter igennem og indsætter i jtable
		for (Tilmeld tilmeld : medlemmer) 
		{
			model.addRow(new Object[]
					{

					tilmeld.getFk_aktivitetID(), tilmeld.getFk_medlemNavn()



					});	
		}

		medlemmer.clear();
	}//updateJTable slutter

	/* (non-Javadoc)
	 * @see GUI.MainGUI#actionPerformed(java.awt.event.ActionEvent)
	 * Indeholder actionlistener til at indsætte i db
	 */
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

		if(e.getSource() == btn_saldo )
		{
			new SaldoGUI();

			frame.dispose();
		}


		if(e.getSource() == btn_barbog)
		{
			new BarBogGUI();
			frame.dispose();
		}

		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			frame.dispose();
		}



		if(e.getSource() == btn_gem)
		{
			Medlem m = (Medlem) medlemBox.getSelectedItem();

			Aktivitet a = (Aktivitet) aktivitetBox.getSelectedItem();
			int id = 0;
			String fk_medlemNavn = m.getFornavn();
			int fk_aktivitetID = a.getid();
			try
			{

				new Control().opretTilmelding(id, fk_medlemNavn, fk_aktivitetID);


			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(frame,"Et eller flere felter er ikke blevet udfyldt. Udfyld alle felter, og prøv igen.");
			}
		}

	}//actionperformed slutter
}//public class slutter
