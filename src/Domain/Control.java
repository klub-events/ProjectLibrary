package Domain;

import java.util.ArrayList;

import Datalink.*;

/**
 * Klasse som bruges for at GUI laget kan faa information, og sende information til Datalink og Domain laget.<br>
 * Bruges for at holde hvert lag adskildt, og opnå tre lags arkitektur.
 * 
 * <p>Alle kald fra GUI laget som skal ud ad, eller ind til GUI laget sendes igennem her.<br>
 * Hver metode i denne klasse findes i DB_Connect, og er beskrevet heri. Da dette blot er en klasse for gennemgang,<br>
 * er alle metoders funktioner beskrevet i root klassen for hver funktion.</p>
 * @author PeterRaasthøj
 *
 */
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
	public void opdaterMedlemmer(ArrayList <Medlem> opdateMedlem){
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

	public void indsaetBeloeb(int saldo, int input ,int id) {
		int total = math.adder(saldo, input);
		db.indsaetBeloeb(total,id);	
		db.hentBarbog();
	}

	public void traekBeloeb(int saldo, int input,int id) {
		int total = math.substrakter(saldo, input);
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

	public int hentVarePris(String vare) {
		return db.hentVarePris(vare);
		
	}

}


