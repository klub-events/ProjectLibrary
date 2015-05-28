package Domain;

/*SELECT `tilmeldinger`.`fk_medlemNavn`,
`tilmeldinger`.`fk_aktivitetID`
FROM `borupclub`.`tilmeldinger`;*/

public class Tilmeld 
{
	int id;
	String medlemNavn;
	int aktivitetID;
	
	public Tilmeld(int medlemID, String medlemNavn, int aktivitetID) {
		this.id = medlemID;
		this.medlemNavn = medlemNavn;
		this.aktivitetID = aktivitetID;
	}
	public String toString(){
		return (id + ",'"+this.medlemNavn+"'" + ", " + "'"+this.aktivitetID+"'");
	}
	
	public int getFk_aktivitetID() {
		return aktivitetID;
	}

	public void setFk_aktivitetID(int fk_aktivitetID) {
		this.aktivitetID = fk_aktivitetID;
	}

	public String getFk_medlemNavn() {
		return medlemNavn;
	}

	public void setFk_medlemNavn(String fk_medlemNavn) {
		this.medlemNavn = fk_medlemNavn;
	}
	
	public int getFk_medlemID() {
		return id;
	}

	public void setFk_medlemID(int fk_medlemID) {
		this.id = fk_medlemID;
	}

	
	
}
