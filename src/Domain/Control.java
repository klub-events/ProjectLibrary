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
	
	//MedlemsDB controls
	public ArrayList<Medlem> hentMedlemmer(){
		return db.hentMedlemmer();
	}
	
	public void opretMedlem(Medlem medlem){
		db.opretMedlem(medlem);
	}
	
	public void updateDB(ArrayList <Medlem> opdateMedlem){
		db.opdaterMedlemmer(opdateMedlem);
	}
		
	//BarbogsDB Controls
	public ArrayList<Barbog> hentBarbog(){
		return db.hentBarbog();
	}
		
	public void opretBarbog(Barbog barbog){
		db.opretBarbog(barbog);
	}
	
	public void opdaterBarbog(ArrayList<Barbog> opdateBarbog){
		db.opdaterBarbog(opdateBarbog);
	}
}


