package Domain;

import java.util.ArrayList;

import Datalink.DBConnector;
import GUI.MedlemTabel;

public class Control {
	
	private static ArrayList<Medlem> medlemmer;
	public Control(){
	new DBConnector();
	this.medlemmer = DBConnector.getMedlemmer();
	}
	
	public static void startTabel(){
		new MedlemTabel(medlemmer);
	}
}
