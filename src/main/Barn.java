package main;

public class Barn {
		private int alder = 0;
		private String adresse = "";
		private int saldo = 0;
	public Barn(int alder, String adresse, int saldo ) {
		this.alder = alder;
		this.adresse = adresse;
		this.saldo = saldo;
	}
	
	public void setAlder(int alder) {
		this.alder = alder;
		
	}
	public int getAlder(){
		return alder;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresse(){
		return adresse;
	}
	public void setSaldo(int saldo){
		this.saldo = saldo;
	}
	
	public int getSaldo(){
		return saldo;
	}
}
