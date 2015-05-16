package Domain;
import java.util.ArrayList;

import Datalink.*;
import GUI.*;


public class Program {
	
	public static void main(String[] args){
		new DBConnector();
		new MainGUI();
	}
}
