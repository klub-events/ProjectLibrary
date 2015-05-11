package Domain;

public class Medlem{
int id;
String fornavn;
String efternavn;
String adresse;
int fødselsdato;
int telefon;
String email;
String navnPåDør;
Boolean billeder;

	public Medlem(int id, String fornavn, String efternavn, String adresse, int fødselsdato, int telefon, String email, String navnPåDør, Boolean billeder){
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getFødselsdato() {
		return fødselsdato;
	}

	public void setFødselsdato(int fødselsdato) {
		this.fødselsdato = fødselsdato;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNavnPåDør() {
		return navnPåDør;
	}

	public void setNavnPåDør(String navnPåDør) {
		this.navnPåDør = navnPåDør;
	}

	public Boolean getBilleder() {
		return billeder;
	}

	public void setBilleder(Boolean billeder) {
		this.billeder = billeder;
	}
	
	
}

