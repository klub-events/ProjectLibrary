package Domain;

import java.util.ArrayList;

import Datalink.*;
import GUI.*;

public class Control {
private ArrayList<Medlem> medlemmer;

	public Control(){
	this.medlemmer = DBHentMedlemmer.getMedlemmer();
	}
	
	public void startTabel(){
		new DBHentMedlemmer();
		new MedlemTabel(medlemmer);
	}
	
	public void opretMedlem(Medlem medlem){
		new DBOpretMedlem(medlem);
		System.out.println(medlem.toString());
	}	
}

