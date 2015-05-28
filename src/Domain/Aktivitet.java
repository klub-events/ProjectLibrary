package Domain;

public class Aktivitet {
	private int id;
	private String navn;
	private String antal;
	private String dato;
	
	public Aktivitet(int id, String navn, String antal, String dato) {
		this.id = id;
		this.navn = navn;
		this.antal = antal;
		this.dato = dato;
	}
	
	@Override
	public String toString(){
		return id + ",'" + navn + "'," + antal + "'," + dato;
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
