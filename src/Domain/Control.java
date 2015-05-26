package Domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Datalink.*;
import GUI.MedlemGUI;

public class Control {


	//private DB_Connector;
	private DB_Connector db;
	public Control(){
		db = DB_Connector.getInstance();
	}

	public Medlem findMedlem(String identifier) {
		return db.findMedlem(identifier);
	}

	//MedlemsDB controls
	//Bruges til at kalde funktionen, som henter arraylisten, som bliver fyldt med medlemmer fra databasen
	public ArrayList<Medlem> hentMedlemmer(){
		return db.hentMedlemmer();
	}

	//Bruges til at kalde funktionen der opretter nye medlemmer i databasen, ud fra et medlems objekt
	public void opretMedlem(Medlem medlem){
			db.opretMedlem(medlem);
	}

	//Bruges til at kalde funktionen der opdatere alle felter i databasen, med v�rdier
	//hentet fra en arrayliste, fyldt med medlemmer, der komemr fra gui - JTablet.
	public void updateDB(ArrayList <Medlem> opdateMedlem){
		db.opdaterMedlemmer(opdateMedlem);
	}
	//kalder funktionen slet medlem i databasen, med en identifier, alts� id, fra et medlem
	//for at slette et medlem i databasen, p� angivet id's plads
	public void sletMedlem(int identifier) {
		db.sletMedlem(identifier);	

	}

	//BarbogsDB Controls
	//Bruges til at kalde funktionen, som henter arraylisten, som bliver fyldt med "barb�ger" fra databasen
	public ArrayList<Barbog> hentBarbog(){
		return db.hentBarbog();
	}

	//Bruges til at kalde funktionen der opretter nye barb�ger i databasen, ud fra et barbog objekt
	public void opretBarbog(Barbog barbog){
		db.opretBarbog(barbog);
	}

	public void opdaterBarbog(ArrayList<Barbog> opdateBarbog){
		db.opdaterBarbog(opdateBarbog);
	}
	//vare-kontrol
	public void opretVare(Varer vare){
		db.opretVare(vare);
	}
	public void sletVare(int identifier) {
		db.sletVare(identifier);
	}
/**
	public Varer findVare(String identifier) {
		return db.findVare(identifier);
	}
**/
	
	public ArrayList<Varer> hentVarer(){
		return db.hentVarer();
	}
	public void opdaterDBVarer(ArrayList <Varer> opdaterVare){
		db.opdaterDBVarer(opdaterVare);
	}
}


