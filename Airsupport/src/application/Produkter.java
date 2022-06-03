//Nilaksan
package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produkter {
	private int Till�gsproduktID; 
	private float Pris;
	private String Navn;
	private boolean Aktiv;
	
	
	public Produkter(int Till�gsproduktID, float Pris, String Navn, boolean Aktiv){
		this.Till�gsproduktID = Till�gsproduktID;
		this.Pris = Pris;
		this.Navn = Navn;
		this.Aktiv = Aktiv;
		
	}
	public StringProperty getNavn() {
		StringProperty var = new SimpleStringProperty(Navn);
		return var;
	}
		
	public StringProperty getPris() {
		StringProperty var = new SimpleStringProperty(""+Pris);
		return var;
	}
	
	public StringProperty getID() {
		StringProperty var = new SimpleStringProperty(""+Till�gsproduktID);
		return var;
	}
}