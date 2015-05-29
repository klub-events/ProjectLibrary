package GUI;
import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MainGUI extends Thread implements ActionListener
{
	//Laver vinduet
	protected JFrame frame = new JFrame("Administration");
	//Laver et canvas for det der skal på vinduet - top knapperne
	protected JPanel Panel_Top = new JPanel();

	//Laver et canvas for det der skal på vinduet - alt i midten
	protected JPanel Panel_Content = new JPanel();

	//opretter knapperne til toppen af menuen
	protected JButton  btn_saldo = new JButton("SALDO");
	protected JButton  btn_medlem = new JButton("MEDLEM");
	protected JButton  btn_aktivitet = new JButton("AKTIVITET"); 
	protected JButton  btn_tilmeld = new JButton("TILMELD AKTIVITET");
	protected JButton  btn_barbog = new JButton("BARBOG");

	//clock API
	protected static JTextField timeField = new JTextField();
	protected static Calendar cal;
	protected static Date date = new Date();
	protected static SimpleDateFormat df = new SimpleDateFormat("HH:mm");
	protected static TimeThread tt = TimeThread.getInstance();
	protected static Object toilet = new Object();

	public MainGUI()
	{
		//Sætter GUIen til en anden subclasse og ændre layout.
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		//standard gui settings
		frame.setSize(860, 660);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());


		Panel_Top.setLayout( new GridLayout());
		Panel_Content.setLayout(new GridLayout());// MANGLER LAYOUT TIL AT PLACE DE FORSKELLIGE TING
		frame.getContentPane().add(Panel_Top, "North");
		frame.getContentPane().add(Panel_Content, "Center");

		Panel_Top.setBackground(Color.darkGray);
		Panel_Content.setBackground(Color.GRAY);
		Panel_Top.setPreferredSize(new Dimension(50, 50));
		Panel_Content.setPreferredSize(new Dimension(860, 690));

		//opretter knapper med actionlisteners, alle til toppen af menu
		Panel_Top.add(btn_medlem);
		btn_medlem.addActionListener(this);
		btn_medlem.setToolTipText("Administrer tilmeldinger til klubben");
		btn_medlem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		Panel_Top.add(btn_saldo);
		btn_saldo.addActionListener(this);
		btn_saldo.setToolTipText("Administrer medlemmers saldo");
		btn_saldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		Panel_Top.add(btn_barbog);
		btn_barbog.addActionListener(this);
		btn_barbog.setToolTipText("Åben barbogen");
		btn_barbog.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
		Panel_Top.add(btn_aktivitet);
		btn_aktivitet.addActionListener(this);
		btn_aktivitet.setToolTipText("Administrer aktiviter");
		btn_aktivitet.setCursor(new Cursor(Cursor.HAND_CURSOR));

		Panel_Top.add(btn_tilmeld);
		btn_tilmeld.addActionListener(this);
		btn_tilmeld.setToolTipText("Tilmeld til aktiviteter");
		btn_tilmeld.setCursor(new Cursor(Cursor.HAND_CURSOR));

		Panel_Top.add(timeField);
		timeField.setEditable(false);
		timeField.setFocusable(false);
		timeField.setFont(new Font("SansSerif", Font.BOLD, 20));
		timeField.setHorizontalAlignment(JTextField.CENTER);


		Panel_Top.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));// border

		frame.setVisible(true);

	}//Construtor MainGUI slutter


	public static class TimeThread extends Thread implements Runnable{
		public static TimeThread getInstance() {
			if (tt == null) {
				tt = new TimeThread();
			}
			return tt;
		}

		public void run(){
			while(true){
				synchronized(toilet){
					cal = Calendar.getInstance();
					date = cal.getTime();
					timeField.setText(df.format(date));
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}


	public static void startThread(){
		tt.start();
	}
	public void stopThread(){
		tt.stop();
	}


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
			new SaldoGUI();
			frame.dispose();
		}
		if(e.getSource() == btn_barbog )
		{
			new BarBogGUI();
			frame.dispose();
		}

	}//actionPerformed slutter
}//MainGUI slutter
