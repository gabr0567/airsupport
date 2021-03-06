//Nilaksan
package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produkter {
	private int TillægsproduktID; 
	private float Pris;
	private String Navn;
	private boolean Aktiv;
	
	
	public Produkter(int TillægsproduktID, float Pris, String Navn, boolean Aktiv){
		this.TillægsproduktID = TillægsproduktID;
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
		StringProperty var = new SimpleStringProperty(""+TillægsproduktID);
		return var;
	}
}
