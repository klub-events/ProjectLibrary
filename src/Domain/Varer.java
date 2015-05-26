package Domain;

/**
 *  Database-koden for varer-table
CREATE TABLE varer(
ID int PRIMARY KEY AUTO_INCREMENT,
pris int (255) NOT NULL,
navn varchar (255) NOT NULL,
tilgængelig int (1),
antal int (6) NOT NULL);
 * **/
public class Varer {
	int id;
	int pris;
	String vare;
	int tilgængelig;
	int antal;
	
	public Varer(int id, int pris, String vare, int tilgængelig, int antal){
		this.id = id;
		this.pris =pris;
		this.vare = vare;
		this.tilgængelig = tilgængelig;
		this.antal = antal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public String getVare() {
		return vare;
	}

	public void setVare(String vare) {
		this.vare = vare;
	}

	public int getTilgængelig() {
		return tilgængelig;
	}

	public void setTilgængelig(int tilgængelig) {
		this.tilgængelig = tilgængelig;
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}
	
}
