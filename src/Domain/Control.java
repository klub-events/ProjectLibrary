package Domain;

import java.util.ArrayList;

import Datalink.*;
import GUI.*;

public class Control {
	//private DB_Connector;
	private DB_Connector db;
	public Control(){
		db = DB_Connector.getInstance();
	}
	public void hentMedlemmerDB(){
		new DBHentMedlemmer().hentMedlemmer();
	}
	public static void startMedTabel(ArrayList<Medlem> medlemmer){
		new MedlemTabel(medlemmer);
	}
	
	public void opretMedlem(Medlem medlem){
		db.opretMedlem(medlem);
	}
	public void updateDB(ArrayList <Medlem> opdateMedlem){
		new DBUpdateMedlemmer().opdaterMedlemmer(opdateMedlem);
	}
		
	public static void startBarbogTabel(ArrayList<Barbog> barbog){
		new DBHentBarbog();
		new BarbogTabel(barbog);
	}
		
	public void opretBarbog(Barbog barbog){
		new DBOpretBarbog().opretBarbog(barbog);
		System.out.println(barbog.toString());
	}
	public void hentBarbogDB(){
		new DBHentBarbog().hentBarbog();
	}
	public void updateBarbogDB(ArrayList<Barbog> opdateBarbog){
		new DBUpdateBarbog().opdaterBarbog(opdateBarbog);
	}
}


