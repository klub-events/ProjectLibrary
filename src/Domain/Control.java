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
	
	public void hentBarbogDB(){
		new DBHentBarbog().hentBarbog();
	}
	//
	public static void startBarbogTabel(ArrayList<Barbog> barbog){
		new BarbogTabel(barbog);
	//	new DBHentBarbog();
	//	new BarbogTabel(barbogs);
	}
	
	public void opretBarbog(Barbog barbog){
		new DBOpretBarbog().opretBarbog(barbog);
		//new DBOpretBarbog(barbog);
		//System.out.println(barbog.toString());
	}	
	//
	public static void startTabel(ArrayList<Medlem> medlemmer){
		new MedlemTabel(medlemmer);
	}
	
	public void opretMedlem(Medlem medlem){
		new DBOpretMedlem().opretMedlem(medlem);
	}
	public void updateDB(ArrayList <Medlem> opdateMedlem){
		new DBUpdateMedlemmer().opdaterMedlemmer(opdateMedlem);
	}
	public void updateBarbogDB(ArrayList <Barbog> opdateBarbog){
		new DBUpdateBarbog().opdaterBarbog(opdateBarbog);
	}
}

