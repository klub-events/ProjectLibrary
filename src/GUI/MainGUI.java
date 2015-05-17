package GUI;
import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainGUI implements ActionListener
{
	//Laver vinduet
	 protected JFrame frame = new JFrame("Administration");
	 //Laver et canvas for det der skal på vinduet - top knapperne
	 protected JPanel Panel_Top = new JPanel();
	 
	//Laver et canvas for det der skal på vinduet - alt i midten
	 protected JPanel Panel_Midt = new JPanel();
	 
	 //opretter knapperne til toppen af menuen
	 protected JButton  btn_saldo = new JButton("SALDO");
	 protected JButton  btn_medlem = new JButton("MEDLEM");
	 protected JButton  btn_aktivitet = new JButton("AKTIVITET"); 
	 protected JButton  btn_tilmeld = new JButton("TILMELD AKTIVITET");
	
	public MainGUI()
	{
		
		//standard gui settings
		 frame.setSize(960, 790);
	     frame.setLocationRelativeTo(null);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setLayout(new BorderLayout());
	    	   
	     
	     Panel_Top.setLayout( new GridLayout());
	     Panel_Midt.setLayout(new GridLayout());// MANGLER LAYOUT TIL AT PLACE DE FORSKELLIGE TING
	     frame.getContentPane().add(Panel_Top, "North");
	     frame.getContentPane().add(Panel_Midt, "Center");
	     
	     Panel_Top.setBackground(Color.darkGray);
	     Panel_Midt.setBackground(Color.GRAY);
	     Panel_Top.setPreferredSize(new Dimension(100, 100));
	     Panel_Midt.setPreferredSize(new Dimension(860, 690));
	     
	     //opretter knapper med actionlisteners, alle til toppen af menu
	     Panel_Top.add(btn_medlem);
	     btn_medlem.addActionListener(this);
	     btn_medlem.setToolTipText("Administrer tilmeldinger til klubben");
	     btn_medlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
	     
	     
	     Panel_Top.add(btn_aktivitet);
	     btn_aktivitet.addActionListener(this);
	     btn_aktivitet.setToolTipText("Administrer aktiviter");
	     btn_aktivitet.setCursor(new Cursor(Cursor.HAND_CURSOR));
	     
	     Panel_Top.add(btn_saldo);
	     btn_saldo.addActionListener(this);
	     btn_saldo.setToolTipText("Administrer medlemmers saldo");
	     btn_saldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    
	     Panel_Top.add(btn_tilmeld);
	     btn_tilmeld.addActionListener(this);
	     btn_tilmeld.setToolTipText("Tilmeld til aktiviteter");
	     btn_tilmeld.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   
	    
	     Panel_Top.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));// border
	     
	     frame.setVisible(true);
		
	}//Construtor MainGUI slutter
	
	//Actions til knapper
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
		
		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			
			frame.dispose();
		}
		if(e.getSource() == btn_saldo){
			new BarBogGUI();
			
			frame.dispose();
		}
		
	}//actionPerformed slutter
}//MainGUI slutter
