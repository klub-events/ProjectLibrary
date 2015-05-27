package Domain;

public class Tilmeld 
{
	String fk_medlemNavn;
	int fk_aktivitetID;
	
	public Tilmeld(String fk_medlemNavn, int fk_aktivitetID) {
		super();
		this.fk_medlemNavn = fk_medlemNavn;
		this.fk_aktivitetID = fk_aktivitetID;
	}
	public String toString(){
		return (String) ("'"+this.fk_medlemNavn+"'" + ", " + "'"+this.fk_aktivitetID+"'");
	}
	
	public int getFk_aktivitetID() {
		return fk_aktivitetID;
	}

	public void setFk_aktivitetID(int fk_aktivitetID) {
		this.fk_aktivitetID = fk_aktivitetID;
	}

	public String getFk_medlemNavn() {
		return fk_medlemNavn;
	}

	public void setFk_medlemNavn(String fk_medlemNavn) {
		this.fk_medlemNavn = fk_medlemNavn;
	}

	
	
}
