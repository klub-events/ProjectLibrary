package Domain;

import java.util.ArrayList;

import Datalink.DBConnector;
import GUI.MedlemTabel;

public class Control {
private ArrayList<Medlem> medlemmer;

	public Control(){
	this.medlemmer = DBConnector.getMedlemmer();
	}
	
	public void startTabel(){
		new MedlemTabel(medlemmer);
	}
	
	public void opretMedlem(Medlem medlem){
		new OpretMedlem(medlem);
		System.out.println(medlem.toString());
	}	
}

