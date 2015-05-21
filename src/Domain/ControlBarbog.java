package Domain;

import java.util.ArrayList;

import Datalink.DBHentBarbog;
import Datalink.DBOpretBarbog;
import GUI.BarbogTabel;

public class ControlBarbog {
private ArrayList<Barbog> barbogs;
/**
	public ControlBarbog(){
	this.barbogs = DBHentBarbog.getBarbog();
	}
	
	public void startTabel(){
		new DBHentBarbog();
		new BarbogTabel(barbogs);
	}
	
	public void opretBarbog(Barbog barbog){
		new DBOpretBarbog(barbog);
		System.out.println(barbog.toString());
	}
**/	
}
