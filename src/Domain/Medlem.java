package Domain;

public class Medlem{
	/**
	 *  Database-koden for varer-table
	   	CREATE TABLE medlemmer(
		ID int NOT NULL AUTO_INCREMENT,
	 	Fornavn varchar(255) NOT NULL,
		Efternavn varchar(255) NOT NULL,
	  	Adresse varchar (255),
	  	Fødselsdato int(6) NOT NULL,
		Telefon int (10),
		Email varchar (255),
		NavnPåDør varchar (255),
		Billeder TINYINT (1),
		PRIMARY KEY (ID)
		)
* **/
	private int id;
	private String fornavn;
	private String efternavn;
	private String adresse;
	private String fødselsdato;
	private String telefon;
	private String email;
	private String navnPåDør;
	private	int billeder;

	public Medlem(int id, String fornavn, String efternavn, String adresse, String fødselsdato, String telefon, String email, String navnPåDør, int billeder){
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

	public String toString(){
		return (String) ("'"+this.id+"'" + ", " + "'"+this.fornavn+"'" + ", " + "'"+this.efternavn+"'" + ", " + "'"+this.adresse+"'" + ", "+"'" + this.fødselsdato +"'"+ ", "+"'" + this.telefon +"'"+ ", " + "'"+this.email+"'" + ", " + "'"+this.navnPåDør+"'" + ", " + "'"+this.billeder+"'");
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

	public String getFødselsdato() {
		return fødselsdato;
	}

	public void setFødselsdato(String fødselsdato) {
		this.fødselsdato = fødselsdato;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
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

	public int getBilleder() {
		return billeder;
	}

	public void setBilleder(int billeder) {
		this.billeder = billeder;
	}
	
	
}

