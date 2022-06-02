//Nilaksan
package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rprodukter {
	private int Till�gsproduktID;
	private String Navn;
	private int till�gsprodukter;
	private int BilletID;
	private float Pris;
	private int Antal;
	
	public Rprodukter(int Till�gsproduktID, String Navn, int till�gsprodukter, int BilletID, float Pris, int Antal){
		this.Till�gsproduktID = Till�gsproduktID;
		this.Navn = Navn;
		this.till�gsprodukter = till�gsprodukter;
		this.Pris = Pris;
		this.Antal = Antal;
	}
	
	public StringProperty getNavn() {
		StringProperty var = new SimpleStringProperty(Navn);
		return var;
	}
		
	public StringProperty getPris() {
		StringProperty var = new SimpleStringProperty(""+Pris);
		return var;
	}
	
	public StringProperty getAntal() {
		StringProperty var = new SimpleStringProperty(""+Antal);
		return var;
	}

	public int getProd() {
		return till�gsprodukter;
	}
	
	public int getID() {
		return Till�gsproduktID;
	}
}
