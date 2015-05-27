package Domain;

public class Barbog {
	int id;
	String vigtigNote;
	int saldo;
	String navn;
	
	public Barbog(int id, String navn, String vigtigNote, int saldo) {
		super();
		this.navn = navn;
		this.id = id;
		this.vigtigNote = vigtigNote;
		this.saldo = saldo;
	}
	public String toString(){
		return (String) ("'"+this.id+"'" + ", " + "'"+this.vigtigNote+"'" + ", " + "'"+this.saldo+"'");
	}

	public String getNavn(){
		return navn;
	}
	
	public void setNavn(String navn){
		this.navn = navn;
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
	//unsure if proper style
	public void changeSaldo(int saldo) {
		this.saldo = this.saldo + saldo;
	}
	
}
