package Domain;

import java.util.ArrayList;

import Datalink.*;
import GUI.*;

public class Control {
	
	public Control(){
		
	}
	public void hentMedlemmerDB(){
		new DBHentMedlemmer().hentMedlemmer();
	}
	public static void startTabel(ArrayList<Medlem> medlemmer){
		new MedlemTabel(medlemmer);
	}
	
	public void opretMedlem(Medlem medlem){
		new DBOpretMedlem().opretMedlem(medlem);
	}
	public void updateDB(ArrayList <Medlem> opdateMedlem){
		new DBUpdateMedlemmer().opdaterMedlemmer(opdateMedlem);
	}
}

