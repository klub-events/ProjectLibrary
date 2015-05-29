package Domain;

/*
 * Oprettelse af aktivitet tabel
 * 
 	CREATE TABLE aktiviteter (
	id int(11) NOT NULL,
	pris varchar(2),
	navn varchar(255),
    antal varchar (2),
    dato varchar (15),
  	PRIMARY KEY (id)
	)
 *
 *@author PeterRaasthøj
 */
public class AKtivitet {
	private int id;
	private String navn;
	private String pris;
	private String antal;
	private String dato;
	
	public AKtivitet(int id, String navn,String pris, String antal, String dato) {
		this.id = id;
		this.navn = navn;
		this.pris = pris;
		this.antal = antal;
		this.dato = dato;
	}
	

	@Override
	public String toString() {
		return (id + ",'"+this.navn+"'" + ", " + "'"+this.pris+"'" + ", " + "'"+this.antal+"'" + ", " + "'"+this.dato+"'");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getPris() {
		return pris;
	}

	public void setPris(String pris) {
		this.pris = pris;
	}
	
	public String getAntal() {
		return antal;
	}

	public void setAntal(String antal) {
		this.antal = antal;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	

}
