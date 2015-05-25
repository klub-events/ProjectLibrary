package Domain;

public class Barbog {
	int id;
	String navn;
	String vigtigNote;
	int saldo;
	
	public Barbog(int id, String navn, String vigtigNote, int saldo) {
		super();
		this.id = id;
		this.navn = navn;
		this.vigtigNote = vigtigNote;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNavn(){
		return navn;
	}
	public void setNavn(String navn){
		this.navn = navn;
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
