package Domain;

public class Barbog {
	int id;
	int pris;
	String vare;
	int tilg�ngelig; 
	String vigtigNote;
	int saldo;
	
	public Barbog(int id, int pris, String vare, int tilg�ngelig, String vigtigNote, int saldo) {
		this.id = id;
		this.vigtigNote = vigtigNote;
		this.saldo = saldo;
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

	public int getTilg�ngelig() {
		return tilg�ngelig;
	}
	public void setTilg�ngelig(int tilg�ngelig) {
		this.tilg�ngelig = tilg�ngelig;
	}

	public String getVigtigNote() {
		return vigtigNote;
	}
	public void setVigtigNote(String vigtigNote) {
		this.vigtigNote = vigtigNote;
	}

	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
}
