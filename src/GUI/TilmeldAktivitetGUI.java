package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TilmeldAktivitetGUI extends MainGUI implements ActionListener
{
	public TilmeldAktivitetGUI()
	{
		btn_tilmeld.setBackground(Color.white);
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
	}
}//public class slutter
