package Datalink;

public class Medlemmer{
int id;
String fornavn;
String efternavn;
String adresse;
int f�dselsdato;
int telefon;
String email;
String navnP�D�r;
Boolean billeder;

	public Medlemmer(int id, String fornavn, String efternavn, String adresse, int f�dselsdato, int telefon, String email, String navnP�D�r, Boolean billeder){
		this.id = id;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.adresse = adresse;
		this.f�dselsdato = f�dselsdato;
		this.telefon = telefon;
		this.email = email;
		this.navnP�D�r = navnP�D�r;
		this.billeder = billeder;
	}
}

