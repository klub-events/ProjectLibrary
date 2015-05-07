package main;

public class Barn {
		private int ID;
		private int alder = 0;
		private String adresse = "";
		private int saldo = 0;
		private int kontaktNr;
		private String navnPåDør;
		
	public Barn(int ID, int alder, int kontaktNr, String adresse, String navnPåDør, int saldo ) {
		this.ID = ID;
		this.kontaktNr = kontaktNr;
		this.alder = alder;
		this.adresse = adresse;
		this.navnPåDør = navnPåDør;
		this.saldo = saldo;
	}
	
	public void setAlder(int alder) {
		this.alder = alder;
	}
	public int getAlder(){
		return alder;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresse(){
		return adresse;
	}
	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
	public void setNavnPåDør(String navnPåDør){
		this.navnPåDør = navnPåDør;
	}
	
	public String getNavnPåDør(){
		return navnPåDør;
	}
	public void setKontaktNr(int kontaktNr){
		this.kontaktNr = kontaktNr;
	}
	
	public int getKontaktNr(){
		return kontaktNr;
	}
	public void setSaldo(int saldo){
		this.saldo = saldo;
	}
	
	public int getSaldo(){
		return saldo;
	}
}
