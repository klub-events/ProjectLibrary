package Domain;

/*
 * Statement for oprettelse af tilmeld table 
 * 
  CREATE TABLE `tilmeld` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_medlemNavn` varchar(50) NOT NULL,
  `aktivitetID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
	)
 *
 */


/**
 * Tilmeld objekt. Dette bruges til at holde information fra databasen,<br>
 * Getters og Setters er tilgængelige for hver værdi.
 * 
 * <p>Indeholder toString() override som lader Varer objekter sættes nemt ind i en mySQL syntax
 * @author PeterRaasthøj PatrickRavnsholt
 *
 */
public class Tilmeld 
{
	int id;
	String medlemNavn;
	String aktivitetNavn;
	
	public Tilmeld(int medlemID, String medlemNavn, String aktivitetNavn) {
		this.id = medlemID;
		this.medlemNavn = medlemNavn;
		this.aktivitetNavn = aktivitetNavn;
	}
	public String toString(){
		return (id + ",'"+this.medlemNavn+"'" + ", " + "'"+this.aktivitetNavn+"'");
	}
	
	public String getFk_aktivitetID() {
		return aktivitetNavn;
	}

	public void setFk_aktivitetID(String fk_aktivitetID) {
		this.aktivitetNavn = fk_aktivitetID;
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
