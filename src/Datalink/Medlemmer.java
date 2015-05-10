package Datalink;

public class Medlemmer{
int id;
String fornavn;
String efternavn;
String adresse;
int fødselsdato;
int telefon;
String email;
String navnPåDør;
boolean billeder;

	public Medlemmer(int id, String fornavn, String efternavn, String adresse, int fødselsdato, int telefon, String email, String navnPåDør, boolean billeder){
		this.id = id;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.adresse = adresse;
		this.fødselsdato = fødselsdato;
		this.telefon = telefon;
		this.email = email;
		this.navnPåDør = navnPåDør;
		this.billeder = billeder;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getFornavn() {
		return fornavn;
	}	
	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}
	public String getEfternavn() {
		return efternavn;
	}	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresse() {
		return adresse;
	}	
	public void setFødselsdato(int fødselsdato) {
		this.fødselsdato = fødselsdato;
	}
	public int getFødselsdato() {
		return fødselsdato;
	}	
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	public int getTelefon() {
		return telefon;
	}	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}	
	public void setNavnPåDør(String navnPåDør) {
		this.navnPåDør = navnPåDør;
	}
	public String getNavnPåDør() {
		return navnPåDør;
	}	
	public void setBilleder(boolean billeder) {
		this.billeder = billeder;
	}
	public boolean getBilleder() {
		return billeder;
	}
}

