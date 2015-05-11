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
    
	 JFrame frame = new JFrame("Administration");

	 JPanel Panel_Top = new JPanel();
	 
	 JPanel Panel_Midt = new JPanel();
	 
	 JButton  btn_medlem = new JButton("MEDLEM");
	 JButton  btn_aktivitet = new JButton("AKTIVITET"); 
	 JButton  btn_Test = new JButton("#");
	
	public MainGUI()
	{
		
		
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
	     
	     Panel_Top.add(btn_medlem);
	     btn_medlem.addActionListener(this);
	     btn_medlem.setCursor(new Cursor(Cursor.HAND_CURSOR));
	     
	     
	     Panel_Top.add(btn_aktivitet);
	     btn_aktivitet.addActionListener(this);
	     btn_aktivitet.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    
	     Panel_Top.add(btn_Test);
	     btn_Test.addActionListener(this);
	     btn_Test.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   
	    
	     Panel_Top.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));// border
	     
	     frame.setVisible(true);
		 
		
		
		
		
	}//Construtor MainGUI slutter
	
	
	
	
	
	//Actions til knapper
	public void actionPerformed(ActionEvent e)
	{	  
		if(e.getSource() == btn_aktivitet)
	    {
			new aktivitet_GUI();
		
	       frame.dispose();
	    }
		
		if(e.getSource() == btn_medlem )
	    {
		   new medlem_GUI();
		
	       frame.dispose();
	    }
		
	}//actionPerformed slutter
}//MainGUI slutter
