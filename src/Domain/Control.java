package Domain;

import java.util.ArrayList;

import Datalink.*;
import GUI.MedlemGUI;

public class Control {
	//private DB_Connector;
	private DB_Connector db;
	private Udregning math;
	public Control(){
		db = DB_Connector.getInstance();
		math = new Udregning();
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
	
	//bruges til at kalde funktioner der opretter nye tilmeldinger 
	 public void opretTilmelding(int id , String fk_medlemNavn, int fk_aktivitetID)
	 {
	 	db.opretTilmelding(id, fk_medlemNavn, fk_aktivitetID);
	 }
	 
     //bruges til at kalde funktioner der opretter nye aktiviteter 
	 public void opretAktivitet(Aktivitet aktivitet)
	 {
	 	db.opretAktivitet(aktivitet);
	 }

	//Bruges til at kalde funktionen der opdatere alle felter i databasen, med værdier
	//hentet fra en arrayliste, fyldt med medlemmer, der komemr fra gui - JTablet.
	public void updateDB(ArrayList <Medlem> opdateMedlem){
		db.opdaterMedlemmer(opdateMedlem);
	}
	//kalder funktionen slet medlem i databasen, med en identifier, altså id, fra et medlem
	//for at slette et medlem i databasen, på angivet id's plads
	public void sletMedlem(int identifier) {
		db.sletMedlem(identifier);	

	}

	//BarbogsDB Controls
	//Bruges til at kalde funktionen, som henter arraylisten, som bliver fyldt med "barbøger" fra databasen
	public ArrayList<Barbog> hentBarbog(){
		return db.hentBarbog();
	}

	//Bruges til at kalde funktionen der opretter nye barbøger i databasen, ud fra et barbog objekt
	public void opretBarbog(Barbog barbog, Medlem medlem){
		db.opretBarbog(barbog,medlem);
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

	public void indsaetBeloeb(int saldo, int input ,int id) {
		int total = math.adder(saldo, input);
		db.indsaetBeloeb(total,id);	
		db.hentBarbog();
	}

	public void traekBeloeb(int saldo, int input,int id) {
		int total = math.substract(saldo, input);
		db.traekBeloeb(total,id);
		db.hentBarbog();
		}

	public ArrayList<Aktivitet> hentAktiviteter() {
		return db.hentAktiviteter();
	}
	
	public ArrayList<Tilmeld> hentTilmeldinger() {
		return db.hentTilmeldinger();
	}

	public void updateNote(int identifier, String note) {
		db.updateNote(identifier, note);
		
	}

}


