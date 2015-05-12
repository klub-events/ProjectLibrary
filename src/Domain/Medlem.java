package Domain;

public class Medlem{
int id;
String fornavn;
String efternavn;
String adresse;
int f�dselsdato;
int telefon;
String email;
String navnP�D�r;
Boolean billeder;

	public Medlem(int id, String fornavn, String efternavn, String adresse, int f�dselsdato, int telefon, String email, String navnP�D�r, Boolean billeder){
		this.id = id;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.adresse = adresse;
		this.f�dselsdato = f�dselsdato;
		this.telefon = telefon;
		this.email = email;
		this.navnP�D�r = navnP�D�r;
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

	public int getF�dselsdato() {
		return f�dselsdato;
	}

	public void setF�dselsdato(int f�dselsdato) {
		this.f�dselsdato = f�dselsdato;
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

	public String getNavnP�D�r() {
		return navnP�D�r;
	}

	public void setNavnP�D�r(String navnP�D�r) {
		this.navnP�D�r = navnP�D�r;
	}

	public Boolean getBilleder() {
		return billeder;
	}

	public void setBilleder(Boolean billeder) {
		this.billeder = billeder;
	}
	
	
}
