package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class medlem_GUI extends MainGUI implements ActionListener
{
	
	JButton btn_visMember = new JButton();
	
	public medlem_GUI(){
		  btn_medlem.setBackground(Color.white);	
		  btn_visMember.addActionListener(this);
		  Panel_Midt.add(btn_visMember);
		
	}//constructor slutter
	
	public void actionPerformed(ActionEvent e){	  
		if(e.getSource() == btn_visMember) {
			System.out.println("vis member clicked");
		new Datalink.db_Connector();
		
	       
	    }
	}
}//public class medlem_GUI slutter
