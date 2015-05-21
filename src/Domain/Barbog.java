package Domain;

public class Barbog {
	int id;
	int pris;
	String vare;
	int tilgængelig; 
	String vigtigNote;
	int saldo;
	
	public Barbog(int id, String vigtigNote, int saldo) {
		super();
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
