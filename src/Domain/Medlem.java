package Domain;

public class Medlem{

	private int id;
	private String fornavn;
	private String efternavn;
	private String adresse;
	private int f�dselsdato;
	private int telefon;
	private String email;
	private String navnP�D�r;
	private	int billeder;

	public Medlem(int id, String fornavn, String efternavn, String adresse, int f�dselsdato, int telefon, String email, String navnP�D�r, int billeder){
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

	public String toString(){
		return (String) ("'"+this.id+"'" + ", " + "'"+this.fornavn+"'" + ", " + "'"+this.efternavn+"'" + ", " + "'"+this.adresse+"'" + ", " + this.f�dselsdato + ", " + this.telefon + ", " + "'"+this.email+"'" + ", " + "'"+this.navnP�D�r+"'" + ", " + "'"+this.billeder+"'");
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

	public int getBilleder() {
		return billeder;
	}

	public void setBilleder(int billeder) {
		this.billeder = billeder;
	}
	
	
}

