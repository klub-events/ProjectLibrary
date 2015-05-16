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
	
	public void opretMedlem(String[] strInfo, int[] intInfo, Boolean billeder){
		Medlem medlem = new Medlem (0, strInfo[0], strInfo[1], strInfo[2], intInfo[0], intInfo[1], strInfo[3], strInfo[4], billeder);
		System.out.println(medlem.toString());
		new OpretMedlem(medlem);
	}
}
