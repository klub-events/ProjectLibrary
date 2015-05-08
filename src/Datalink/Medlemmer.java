package Datalink;

public class Medlemmer{
int id;
String fornavn;
String efternavn;
String adresse;
int fødselsdato;
int telefon;
String email;
String navnPåDør;
Boolean billeder;

	public Medlemmer(int id, String fornavn, String efternavn, String adresse, int fødselsdato, int telefon, String email, String navnPåDør, Boolean billeder){
		this.id = id;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.adresse = adresse;
		this.fødselsdato = fødselsdato;
		this.telefon = telefon;
		this.email = email;
		this.navnPåDør = navnPåDør;
		this.billeder = billeder;
	}
}

